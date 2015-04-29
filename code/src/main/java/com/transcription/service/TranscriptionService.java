package com.transcription.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.data.MedicalStaff;
import com.authentication.data.Physician;
import com.authentication.service.CustomUserDetailsService;
import com.constant.ConstantValue;
import com.diagnostic_test.data.DiagnosticTest;
import com.diagnostic_test.service.DiagnosticTestServcie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.medical_staff.service.MedicalStaffService;
import com.patient.data.Patient;
import com.patient.service.PatientService;
import com.physician.service.PhysicianService;
import com.relation_transcription_diagnostic_test.data.TranscriptionDiagnosticRelation;
import com.relation_transcription_diagnostic_test.service.TranscriptionDiagnosticRelationService;
import com.relation_transcription_surgery.data.TranscriptionSurgeryRelation;
import com.relation_transcription_surgery.service.TranscriptionSurgeryRelationService;
import com.relation_transcription_treatment.data.TreatmentRelation;
import com.relation_transcription_treatment.service.TreatmentRelationService;
import com.surgery.data.Surgery;
import com.surgery.service.SurgeryService;
import com.transcription.dao.TranscriptionDao;
import com.transcription.data.BillToAdmin;
import com.transcription.data.Transcription;
import com.treatment.data.Treatment;
import com.treatment.service.TreatmentService;

@Service
public class TranscriptionService {
	@Autowired
	TranscriptionDao transcriptionDao;
	@Autowired
	PatientService pService;
	@Autowired
	PhysicianService physicianService;
	@Autowired
	MedicalStaffService msService;
	@Autowired
	TranscriptionDiagnosticRelationService diagnosticRelationService;
	@Autowired
	TranscriptionSurgeryRelationService sugeryRelationService;
	@Autowired
	TreatmentRelationService treatmentRelationService;
	@Autowired
	DiagnosticTestServcie diagnosticTestServcie;
	@Autowired
	SurgeryService surgeryService;
	@Autowired
	TreatmentService treatmentService;

	public List<Transcription> getTranscriptionsByEmrId(int emrId) {
		List<Transcription> list = transcriptionDao
				.findTranscriptionsByEmrId(emrId);
		return list;
	}

	public Transcription getTranscriptionById(int transcription_id) {
		Transcription transcription = transcriptionDao
				.findTranscriptionById(transcription_id);
		return transcription;
	}

	public Integer create(int emrId, int patientId) {
		// TODO Auto-generated method stub
		Transcription transcription = new Transcription();
		transcription.setEmr_id(emrId);
		transcription.setPatient_id(patientId);
		Patient p = pService.getPatientById(patientId);
		transcription.setPatient_ssn(p.getSsn());
		transcription.setPatient_name(p.getPatient_name());
		transcription.setAbstraction("");
		transcription.setContent("");
		if (CustomUserDetailsService.isMedicalStaff()) {
			MedicalStaff ms = msService
					.getMedicalstaffById(CustomUserDetailsService
							.currentUserDetails().getUserId());
			Physician phsician = physicianService.getPhysicianById(ms
					.getPhysician_id());
			transcription.setPhysician_id(phsician.getPhysician_id());
			transcription.setPhysician_name(phsician.getPhysician_name());
			transcription.setWriter_id(ms.getMsid());
			transcription.setWriter_name(ms.getMs_name());
			transcription.setWriter_type(ConstantValue.MEDICAL_STAFF);
		} else if (CustomUserDetailsService.isPhysician()) {
			Physician currentPhysician = physicianService.currentPhysician();
			transcription.setPhysician_id(currentPhysician.getPhysician_id());
			transcription.setPhysician_name(currentPhysician
					.getPhysician_name());
			transcription.setWriter_id(currentPhysician.getPhysician_id());
			transcription.setWriter_name(currentPhysician.getPhysician_name());
			transcription.setWriter_type(ConstantValue.PHYSICIAN);
		}
		Date date = new Date();
		transcription.setCreate_date(date);
		return transcriptionDao.create(transcription);
	}

	public void update(int transcriptionId, String content, String abstraction) {
		// TODO Auto-generated method stub
		transcriptionDao.update(transcriptionId, content, abstraction);
	}

	public void sendBillToAdmin(int transcriptionId) {
		// TODO Auto-generated method stub
		BillToAdmin bta = new BillToAdmin();
		Transcription trans = transcriptionDao
				.findTranscriptionById(transcriptionId);
		bta.setTrans(trans);
		List<TranscriptionDiagnosticRelation> diagnosticList = diagnosticRelationService
				.getByTranscriptionId(transcriptionId);
		List<TranscriptionSurgeryRelation> surgeryList = sugeryRelationService
				.getByTranscriptionId(transcriptionId);
		List<TreatmentRelation> treatmentList = treatmentRelationService
				.getByTranscriptionId(transcriptionId);

		for (TranscriptionDiagnosticRelation tdr : diagnosticList) {
			DiagnosticTest dt = diagnosticTestServcie.getById(tdr
					.getDiagnostic_test_id());
			tdr.setPrice(dt.getCost() + "");
		}
		for (TranscriptionSurgeryRelation tsr : surgeryList) {
			Surgery s = surgeryService.getById(tsr.getSurgery_id());
			tsr.setPrice(s.getCost() + "");
		}
		for (TreatmentRelation tr : treatmentList) {
			Treatment t = treatmentService.getById(tr.getTreatment_id());
			tr.setPrice(t.getTreatment_price());
		}
		bta.setDiagnosticList(diagnosticList);
		bta.setSurgeryList(surgeryList);
		bta.setTreatmentList(treatmentList);
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(bta);
			System.out.println(json);
			String url = "http://138.49.101.81/Administrative/bill/getEMRData";
					//"http://138.49.101.81/Administrative/bill/getEMRData";
					//"http://172.31.156.156:8080/admin/bill/getEMRData";
			this.postToUrl(url, json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void postToUrl(String url, String json) {
		HttpClient httpClient = HttpClientBuilder.create().build(); // Use this
																	// //
																	// instead
		try {
			HttpPost request = new HttpPost(url);
			StringEntity params = new StringEntity(json);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			System.out.println("status code = "
					+ response.getStatusLine().getStatusCode());
			InputStream ips = response.getEntity().getContent();
			BufferedReader buf = new BufferedReader(new InputStreamReader(ips,
					"UTF-8"));
			StringBuilder sb = new StringBuilder();
			String s;
			while (true) {
				s = buf.readLine();
				if (s == null || s.length() == 0)
					break;
				sb.append(s);

			}
			buf.close();
			ips.close();
			System.out.println(sb.toString());
			// handle response here...
		} catch (Exception ex) {
			// handle exception here
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
}

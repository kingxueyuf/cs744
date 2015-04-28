package com.transcription.data;

import java.util.List;

import com.relation_transcription_diagnostic_test.data.TranscriptionDiagnosticRelation;
import com.relation_transcription_surgery.data.TranscriptionSurgeryRelation;
import com.relation_transcription_treatment.data.TreatmentRelation;

public class BillToAdmin {
	Transcription trans;

	List<TranscriptionDiagnosticRelation> diagnosticList;
	List<TranscriptionSurgeryRelation> surgeryList;
	List<TreatmentRelation> treatmentList;

	public Transcription getTrans() {
		return trans;
	}

	public void setTrans(Transcription trans) {
		this.trans = trans;
	}

	public List<TranscriptionDiagnosticRelation> getDiagnosticList() {
		return diagnosticList;
	}

	public void setDiagnosticList(
			List<TranscriptionDiagnosticRelation> diagnosticList) {
		this.diagnosticList = diagnosticList;
	}

	public List<TranscriptionSurgeryRelation> getSurgeryList() {
		return surgeryList;
	}

	public void setSurgeryList(List<TranscriptionSurgeryRelation> surgeryList) {
		this.surgeryList = surgeryList;
	}

	public List<TreatmentRelation> getTreatmentList() {
		return treatmentList;
	}

	public void setTreatmentList(List<TreatmentRelation> treatmentList) {
		this.treatmentList = treatmentList;
	}

}

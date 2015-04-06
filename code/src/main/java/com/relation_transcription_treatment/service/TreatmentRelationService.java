package com.relation_transcription_treatment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation_transcription_treatment.dao.TreatmentRelationDao;
import com.relation_transcription_treatment.data.TreatmentRelation;

@Service
public class TreatmentRelationService {
	@Autowired
	TreatmentRelationDao trDao;
	
	public void add(TreatmentRelation tr) {
		// TODO Auto-generated method stub
		trDao.add(tr);
	}

	public List<TreatmentRelation> getByTranscriptionId(int transcriptionId) {
		// TODO Auto-generated method stub
		return trDao.getByTranscriptionId(transcriptionId);
	}

}

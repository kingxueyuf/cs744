package com.transcription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transcription.dao.TranscriptionDao;
import com.transcription.data.Transcription;

@Service
public class TranscriptionService {
	
	@Autowired
	TranscriptionDao transcriptionDao;

	public List<Transcription> getTranscriptionsByEmrId( int emrId ){
		List<Transcription> list = transcriptionDao.findTranscriptionsByEmrId(emrId);
		return list;
	}
	
	public Transcription getTranscriptionById( int transcription_id ){
		Transcription transcription = transcriptionDao.findTranscriptionById( transcription_id );
		return transcription;
	}
	
}

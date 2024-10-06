package com.ehrs.restapi.Exception;

class PatientsNotFoundException extends RuntimeException{
	public PatientsNotFoundException(String message){
        super(message);
    }
}

class PatientsCreateException extends RuntimeException{
	public PatientsCreateException(String message){
        super(message);
    }
}

class PatientsUpdateException extends RuntimeException{
	public PatientsUpdateException(String message){
        super(message);
    }
}

class PatientsDeleteException extends RuntimeException{
	public PatientsDeleteException(String message){
        super(message);
    }
}

class PatientsSearchException extends RuntimeException{
	public PatientsSearchException(String message){
        super(message);
    }
}

class PatientsCommunicationException extends RuntimeException{
	public PatientsCommunicationException(String message){
        super(message);
    }
}
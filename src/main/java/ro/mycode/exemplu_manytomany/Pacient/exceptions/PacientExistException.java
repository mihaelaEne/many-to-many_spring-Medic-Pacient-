package ro.mycode.exemplu_manytomany.Pacient.exceptions;

import static ro.mycode.exemplu_manytomany.system.Constants.PACIENT_EXIST;

public class PacientExistException extends RuntimeException{
    public PacientExistException(){super(PACIENT_EXIST);}
}

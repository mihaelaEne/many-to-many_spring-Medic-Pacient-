package ro.mycode.exemplu_manytomany.Medic.exceptions;

import static ro.mycode.exemplu_manytomany.system.Constants.MEDIC_EXIST;

public class MedicExistException extends RuntimeException{
    public MedicExistException(){super(MEDIC_EXIST);}
}

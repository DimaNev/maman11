package nevelev.dima;

/**
 * Created with IntelliJ IDEA.
 * UserInterface: DimaN
 * Date: 01/11/14
 * Time: 09:45
 *
 */
 public class Number {

    private final int NUMBER_OF_DIGITS =4;
    private final String VALID_DIGITS="0123456789";
    private String number;
    private boolean isValid;
    private String validationAnswer="";

    protected int getLength() {
        return NUMBER_OF_DIGITS;
    }

    protected boolean isValid(){
        return this.isValid;
    }

    protected String getValidationAnswer(){
        return validationAnswer;
    }
    protected String getNumber(){
       return new String(this.number);
    }

    protected void setNumber(String providedNumber) {
        this.number=new String(providedNumber);
        this.validateNumber();
    }

    private void validateNumber() {
        String currentChar;
        String remainedSubString;
        boolean validDigits=false;
        boolean noRepeats=false;

        this.isValid = this.number.length() == NUMBER_OF_DIGITS;
        if (!isValid) validationAnswer = "Not valid number length.";

        for(int i=0 ; i<this.number.length() && this.isValid ; i++){
            currentChar = "" + this.number.charAt(i);
            validDigits = VALID_DIGITS.contains(currentChar);
            if (!validDigits) validationAnswer = "The char \""+currentChar+"\" is not a valid char.";

            if(i!=this.number.length()-1){      //for preventing validating the char with itself
                remainedSubString = number.substring(i+1);
                noRepeats= !remainedSubString.contains(currentChar);
                if (!noRepeats) validationAnswer = "The char \""+currentChar+"\" appear more than once.";
            }

            this.isValid=validDigits && noRepeats;
        }

        if(isValid) validationAnswer="The number is valid!";
    }
}

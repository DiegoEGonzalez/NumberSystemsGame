import java.util.Random;




public class Questions
{
    public static String question;
    public static String answer;
    public static int value;

    public Questions() {}

    static boolean octal = true;
    static boolean hexadecimal = true;
    static boolean decimal = true;
    static boolean binary = true;

    public void setOctal(boolean octal) {
        octal = octal;
    }

    public void setHexadecimal(boolean hexadecimal) { hexadecimal = hexadecimal; }

    public void setDecimal(boolean decimal) {
        decimal = decimal;
    }

    public void setBinary(boolean binary) { binary = binary; }

    public boolean isOctal()
    {
        return octal;
    }

    public boolean isHexadecimal() { return hexadecimal; }

    public boolean isDecimal() {
        return decimal;
    }

    public boolean isBinary() { return binary; }

    public static int random(int variety)
    {
        Random r = new Random();
        return r.nextInt(variety);
    }

    public String genBinToDec() {
        question = Integer.toBinaryString(value) + " (2)   to   Decimal.";
        answer = "" + value;
        return question;
    }

    public String genBinToHex() { question = Integer.toBinaryString(value) + " (2)   to   Hexadecimal.";
        answer = "" + Integer.toHexString(value);
        return question;
    }

    public String genBinToOct() { question = Integer.toBinaryString(value) + " (2)   to   Octal.";
        answer = "" + Integer.toOctalString(value);
        return question;
    }

    public String genOctToHex() { question = Integer.toOctalString(value) + " (8)   to   Hexadecimal.";
        answer = "" + Integer.toHexString(value);
        return question;
    }

    public String genOctToBin() { question = Integer.toOctalString(value) + " (8)   to   Binary.";
        answer = "" + Integer.toBinaryString(value);
        return question;
    }

    public String genOctToDec() { question = Integer.toOctalString(value) + " (8)   to   Decimal.";
        answer = "" + value;
        return question;
    }

    public String genHextoDec() { question = Integer.toHexString(value) + " (hex)   to   Decimal.";
        answer = "" + value;
        return question;
    }

    public String genHextoBin() { question = Integer.toHexString(value) + " (hex)   to   Binary.";
        answer = "" + Integer.toBinaryString(value);
        return question;
    }

    public String genHextoOct() { question = Integer.toHexString(value) + " (hex)   to   Octal.";
        answer = "" + Integer.toOctalString(value);
        return question;
    }

    public String genDecToBin() { question = value + " (10)   to   Binary.";
        answer = "" + Integer.toBinaryString(value);
        return question;
    }

    public String genDecToOct() { question = value + " (10)   to   Octal.";
        answer = "" + Integer.toOctalString(value);
        return question;
    }

    public String genDectoHex() { question = value + " (10)   to   Hexadecimal.";
        answer = "" + Integer.toHexString(value);
        return question;
    }

    public String genQuestion(int difficulty) {
        question = "";
        boolean redo = true;
        do {
            if (difficulty == 1) {
                value = random(16);
                switch (random(5)) {
                    case 0:
                        if ((binary == true) && (decimal == true))
                            redo = false;
                        genBinToDec();
                        break;
                    case 1:
                        if ((binary == true) && (decimal == true))
                            redo = false;
                        genDecToBin();
                        break;
                    case 2:
                        if ((hexadecimal == true) && (decimal == true))
                            redo = false;
                        genDectoHex();
                        break;
                    case 3:
                        if ((hexadecimal == true) && (decimal == true))
                            redo = false;
                        genHextoDec();
                        break;
                    case 4:
                        if ((octal == true) && (decimal == true))
                            redo = false;
                        genDecToOct();
                }
            }
            else if (difficulty == 2) {
                value = random(16) + 16;
                switch (random(8)) {
                    case 0:
                        if ((binary == true) && (decimal == true))
                            redo = false;
                        genBinToDec();
                        break;
                    case 1:
                        if ((binary == true) && (decimal == true))
                            redo = false;
                        genDecToBin();
                        break;
                    case 2:
                        if ((hexadecimal == true) && (decimal == true))
                            redo = false;
                        genDectoHex();
                        break;
                    case 3:
                        if ((hexadecimal == true) && (decimal == true))
                            redo = false;
                        genHextoDec();
                        break;
                    case 4:
                        if ((binary == true) && (hexadecimal == true))
                            redo = false;
                        genBinToHex();
                        break;
                    case 5:
                        if ((binary == true) && (hexadecimal == true))
                            redo = false;
                        genHextoBin();
                        break;
                    case 6:
                        if ((octal == true) && (decimal == true))
                            redo = false;
                        genDecToOct();
                        break;
                    case 7:
                        if ((octal == true) && (decimal == true))
                            redo = false;
                        genOctToDec();
                }
            }
            else {
                value = random(16 * (int)Math.pow(2.0D, difficulty - 2) + 16 * (int)Math.pow(2.0D, difficulty - 2));
                switch (random(12)) {
                    case 0:
                        if ((binary == true) && (decimal == true))
                            redo = false;
                        genBinToDec();
                        break;
                    case 1:
                        if ((binary == true) && (decimal == true))
                            redo = false;
                        genDecToBin();
                        break;
                    case 2:
                        if ((hexadecimal == true) && (decimal == true))
                            redo = false;
                        genDectoHex();
                        break;
                    case 3:
                        if ((hexadecimal == true) && (decimal == true))
                            redo = false;
                        genHextoDec();
                        break;
                    case 4:
                        if ((binary == true) && (hexadecimal == true))
                            redo = false;
                        genBinToHex();
                        break;
                    case 5:
                        if ((binary == true) && (hexadecimal == true))
                            redo = false;
                        genHextoBin();
                        break;
                    case 6:
                        if ((octal == true) && (decimal == true))
                            redo = false;
                        genDecToOct();
                        break;
                    case 7:
                        if ((octal == true) && (decimal == true))
                            redo = false;
                        genOctToDec();
                        break;
                    case 8:
                        if ((binary == true) && (octal == true))
                            redo = false;
                        genBinToOct();
                        break;
                    case 9:
                        if ((hexadecimal == true) && (octal == true))
                            redo = false;
                        genHextoOct();
                        break;
                    case 10:
                        if ((binary == true) && (octal == true))
                            redo = false;
                        genOctToBin();
                        break;
                    case 11:
                        if ((octal == true) && (hexadecimal == true))
                            redo = false;
                        genOctToHex();

                }

            }
        } while (redo);
        return question;
    }

    public boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(answer);
    }
}
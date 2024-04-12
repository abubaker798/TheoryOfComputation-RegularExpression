//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static boolean validateEmail(String email){
         String regex = "[A-Za-z0-9_-]+@(gmail|hotmail|yahoo)\\.com";
         Pattern pattern = Pattern.compile(regex);

        if(email.isEmpty()) return false;
        return pattern.matcher(email).matches();
    }

    public static boolean validatePhoneNumber(String phoneNumber){
        String regex = "1+((\\d{8})|((\\d{2})(-\\d{3}-\\d{3})))+0|\\(1+(\\d{2}\\)(-\\d{3}-\\d{3}))+0";
        Pattern pattern = Pattern.compile(regex);

        if(phoneNumber.isEmpty()) return false;
        return pattern.matcher(phoneNumber).matches();
    }

    public static boolean validateDate(String date){
        String regex = "(\\d{1,2})/(\\d{1,2})/(\\d{4})";
        Pattern pattern = Pattern.compile(regex);

        if(date.isEmpty()) return false;
        return pattern.matcher(date).matches();
    }

    public static boolean validateIPAddress(String iP_address){
        String regex = "\\d{3}\\.\\d{3}\\.\\d\\.\\d";
        Pattern pattern = Pattern.compile(regex);

        if(iP_address.isEmpty()) return false;
        return pattern.matcher(iP_address).matches();
    }

    public static boolean validateCppVarNam(String varNam){
       String regex = "(_|[a-zA-Z])(((\\d*)([a-zA-Z]*))*|([a-zA-Z]*)|_*)";
        Pattern pattern = Pattern.compile(regex);

        if(varNam.isEmpty()) return false;
        return pattern.matcher(varNam).matches();
    }

    public static boolean consecutive_bs(String string){
        String regex = "([aAc-zC-Z0-9]*)(b|bb|B|BB)|([aAc-zC-Z0-9]*)(b|bb|B|BB)([aAc-zC-Z0-9]+)(b|bb|B|BB)([aAc-zC-Z0-9]*)";
        Pattern pattern = Pattern.compile(regex);
        if (string.isEmpty())return false;
        return pattern.matcher(string).matches();
    }

    public static void subString(String string, FileWriter outputFile) throws IOException {
        String regex = "((b(bb)*a(aa)*a(aa)*a(aa)*)+|(a(aa)*b(bb)*a(aa)*a(aa)*)+|(a(aa)*a(aa)*b(bb)*a(aa)*)+|(a(aa)*a(aa)*a(aa)*b(bb)*)+)|((a(aa)*b(bb)*b(bb)*b(bb)*)+|(b(bb)*a(aa)*b(bb)*b(bb)*)+|(b(bb)*b(bb)*a(aa)*b(bb)*)+|(b(bb)*b(bb)*b(bb)*a(aa)*)+)|(ab|ba)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(regex);

        Vector<String> str = new Vector<String>();
        Vector<Integer> strEnd = new Vector<Integer>();

        int c = 0, i = 0, j = 0;

        while (matcher.find()){
            str.add(matcher.group());
            strEnd.add(matcher.start());
            strEnd.add(matcher.end());
            c++;
        }
        outputFile.write("*"+string+"*\n");
        System.out.print("*"+string+"*\n");
        outputFile.write("number of matched substrings: "+c+"\n");
        System.out.print("number of matched substrings: "+c+"\n");
        while (c--!=0){
            outputFile.write("matched substring: " + str.get(i++) + "\n");
            System.out.print("matched substring: " + str.get(i) + "\n");
            outputFile.write("start index: "+strEnd.get(j++)+", end index: "+strEnd.get(j++)+"\n");
            System.out.print("start index: "+strEnd.get(j)+", end index: "+strEnd.get(j)+"\n");
            c--;
        }
    }

    public static void IsWordOfThree(String sentenc, FileWriter outputFile) throws IOException {
        String regex = "(\\b\\w{3}\\b)";
        Pattern pattern = Pattern.compile(regex);

        Vector<String> str = new Vector<String>();
        Vector<Integer> strEnd = new Vector<Integer>();

        int c = 0, i = 0, j = 0;

        Matcher matcher = pattern.matcher(sentenc);

        while (matcher.find()){
            c++;
            str.add(matcher.group());
            strEnd.add(matcher.start());
            strEnd.add((matcher.end()));
        }

        outputFile.write("*"+sentenc+"*\n");
        if (c>0){
            outputFile.write("number of matched words: "+c+"\n");
            while (c--!=0){
                outputFile.write("matched word: " + str.get(i++)+"\n");
                outputFile.write("start index: " + strEnd.get(j++) + ",end index: "+strEnd.get(j++)+"\n");
            }
        }
        else{outputFile.write("No word matches\n");}
    }

    public static void URLs(FileWriter  outputFile) throws IOException {
        String regex = "(https://)(\\w+\\.\\w+|\\w+|www\\.\\w+)\\.(com/|com)(\\w+/?)*";
        Pattern pattern = Pattern.compile(regex);

        File urlFile = new File("problem9file.txt");
        Scanner urlReader = new Scanner(urlFile);
        Matcher matcher;

        String text;
        outputFile.write("*problem9file.txt*"+ "\n");

        Vector<String> url = new Vector<String>();
        Vector<Integer> linStrEnd = new Vector<Integer>();
        int line = 0, c = 0, i = 0, j = 0;

        while (urlReader.hasNextLine()) {
            text = urlReader.nextLine(); line++;
            matcher = pattern.matcher(text);
            if (matcher.find()){
                c++;
                url.add(matcher.group());
                linStrEnd.add(line);
                linStrEnd.add(matcher.start());
                linStrEnd.add(matcher.end());
            }
        }

        outputFile.write("Number of URLs: "+c+"\n");
        while (c--!=0){
            outputFile.write("URL: " + url.get(i++)+"\n");
            outputFile.write("Line: " + linStrEnd.get(j++)+"\n");
            outputFile.write("start index: " + linStrEnd.get(j++) + " end index: " + linStrEnd.get(j++)+"\n");
        }
        urlReader.close();
    }

    public static boolean mathExpr(String expr){
        String regex = "(\\d+([a-zA-Z]+)?)([/*+-][/*+-]?)\\d+([a-zA-Z]+)?([/*+-](\\d?([a-zA-Z]+)?))?=((([a-zA-Z]+|\\d+)[/*+-]([a-zA-Z]+|\\d+))|(\\d+))";
        Pattern pattern = Pattern.compile(regex);
        if (expr.isEmpty())return false;
        return pattern.matcher(expr).matches();
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        FileWriter  outputFile = new FileWriter("output.txt");
        Scanner myReader = new Scanner(inputFile);

        //===========> problem 1 <==============
        String data = myReader.nextLine();
        outputFile.write(data + "\n");

        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (Objects.equals(data, "end")){outputFile.write("x\n");break;}
            if(validateEmail(data)){outputFile.write("valid email\n");}
            else {outputFile.write("invalid email\n");}
        }

      //===========> problem 2 <==============
        data = myReader.nextLine();
        outputFile.write(data + "\n");

        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (Objects.equals(data, "end")){outputFile.write("x\n");break;}
            if(validatePhoneNumber(data)){outputFile.write("valid phone number\n");}
            else {outputFile.write("invalid phone number\n");}
        }

        //===========> problem 3 <==============
        data = myReader.nextLine();
        outputFile.write(data + "\n");

        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (Objects.equals(data, "end")){outputFile.write("x\n");break;}
            if(validateDate(data)){outputFile.write("valid date\n");}
            else {outputFile.write("invalid date\n");}
        }

        //===========> problem 4 <==============
        data = myReader.nextLine();
        outputFile.write(data + "\n");

        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (Objects.equals(data, "end")){outputFile.write("x\n");break;}
            if(validateIPAddress(data)){outputFile.write("valid IP address\n");}
            else {outputFile.write("invalid IP address\n");}
        }

        //===========> problem 5 <==============
        data = myReader.nextLine();
        outputFile.write(data + "\n");

        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (Objects.equals(data, "end")){outputFile.write("x\n");break;}
            if(validateCppVarNam(data)){outputFile.write("valid C++ variable name\n"); }
            else {outputFile.write("invalid C++ variable name\n");}
        }

        //===========> problem 6 <==============
        data = myReader.nextLine();
        outputFile.write(data + "\n");

        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (Objects.equals(data, "end")){outputFile.write("x\n");break;}
            if(consecutive_bs(data)){outputFile.write("valid string\n");}
            else {outputFile.write("invalid string, has 3 consecutive b’s\n");}
        }


        //===========> problem 7 <==============
        data = myReader.nextLine();
        outputFile.write(data + "\n");

        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (Objects.equals(data, "end")){outputFile.write("x\n");break;}
            else{subString(data,outputFile);}
        }

        //===========> problem 8 <==============
        data = myReader.nextLine();
        outputFile.write(data + "\n");

        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (Objects.equals(data, "end")){outputFile.write("x\n");break;}
            IsWordOfThree(data,outputFile);
        }


        //===========> problem 9 <==============
        URLs(outputFile);
        data = myReader.nextLine();
        data = myReader.nextLine();
        data = myReader.nextLine();

        //===========> problem 10 <==============

        data = myReader.nextLine();
        outputFile.write(data + "\n");

        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if (Objects.equals(data, "end")){outputFile.write("x\n");break;}
            if(mathExpr(data)){outputFile.write("valid mathematical expression\n");}
            else {outputFile.write("invalid mathematical expression\n");}
        }

        myReader.close();
        outputFile.close();
    }
}
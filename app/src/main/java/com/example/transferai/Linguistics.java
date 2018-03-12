package com.example.transferai;

import java.util.*;
import java.io.*;

public class Linguistics {

    public String content;

    public Linguistics(String emailContent) {
        content = emailContent;
    }

    public String getDate() {
        String weekDay = "";
        String months = "";
        String date = "";
        String year = "";
        //File inFile = new File(inputFileName);
        //Scanner inputFile = new Scanner(inFile);

        // try {



            String singleSegment = content;
            int countDigits = 0;
            for (int index = 0; index < singleSegment.length(); index++) {
                if (Character.isDigit(singleSegment.charAt(index))) {
                    countDigits++;
                }
            }
            if (countDigits >= 3) {
                if (singleSegment.contains("Mon") || singleSegment.contains("Monday")) {
                    weekDay = "Monday";
                }
                else if (singleSegment.contains("Tue") || singleSegment.contains("Tuesday")) {
                    weekDay = "Tuesday";
                }
                else if (singleSegment.contains("Wed") || singleSegment.contains("Wednesday")) {
                    weekDay = "Wednesday";
                }
                else if (singleSegment.contains("Thur") || singleSegment.contains("Thursday")) {
                    weekDay = "Thursday";
                }
                else if (singleSegment.contains("Fri") || singleSegment.contains("Friday")) {
                    weekDay = "Friday";
                }
                else if (singleSegment.contains("Sat") || singleSegment.contains("Saturday")) {
                    weekDay = "Saturday";
                }
                else if (singleSegment.contains("Sun") || singleSegment.contains("Sunday")) {
                    weekDay = "Sunday";
                }

                // JUNUARY
                if (singleSegment.contains("Jan") ) {
                    months = "January";
                    int indexJan = singleSegment.indexOf("Jan");
                    if (Character.isDigit(singleSegment.charAt(indexJan + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexJan + 5))) {
                            date = singleSegment.substring(indexJan + 4, indexJan + 6);
                        }
                        else {
                            date = singleSegment.substring(indexJan + 4, indexJan + 5);
                        }
                    }
                    if (singleSegment.contains("January")) {
                        indexJan = singleSegment.indexOf("January");
                        if (Character.isDigit(singleSegment.charAt(indexJan + 8))) {
                            if (Character.isDigit(singleSegment.charAt(indexJan + 9))) {
                                date = singleSegment.substring(indexJan + 8, indexJan + 10);
                            }
                            else {
                                date = singleSegment.substring(indexJan + 8, indexJan + 9);
                            }
                        }
                    }
                }

                // FEBURARY
                else if (singleSegment.contains("Feb")) {
                    months = "Feburary";
                    int indexFeb = singleSegment.indexOf("Feb");
                    if (Character.isDigit(singleSegment.charAt(indexFeb + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexFeb + 5))) {
                            date = singleSegment.substring(indexFeb + 4, indexFeb + 6);
                        }
                        else {
                            date = singleSegment.substring(indexFeb + 4, indexFeb + 5);
                        }
                    }
                    if (singleSegment.contains("Feburary")) {
                        indexFeb = singleSegment.indexOf("Feburary");
                        if (Character.isDigit(singleSegment.charAt(indexFeb + 9))) {
                            if (Character.isDigit(singleSegment.charAt(indexFeb + 10))) {
                                date = singleSegment.substring(indexFeb + 9, indexFeb + 11);
                            }
                            else {
                                date = singleSegment.substring(indexFeb + 9, indexFeb + 10);
                            }
                        }
                    }
                }

                // MARCH
                else if (singleSegment.contains("Mar")){
                    months = "March";
                    int indexMar = singleSegment.indexOf("Mar");
                    if (Character.isDigit(singleSegment.charAt(indexMar + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexMar + 5))) {
                            date = singleSegment.substring(indexMar + 4, indexMar + 6);
                        }
                        else {
                            date = singleSegment.substring(indexMar + 4, indexMar + 5);
                        }
                    }
                    if (singleSegment.contains("March")) {
                        indexMar = singleSegment.indexOf("March");
                        if (Character.isDigit(singleSegment.charAt(indexMar + 6))) {
                            if (Character.isDigit(singleSegment.charAt(indexMar + 7))) {
                                date = singleSegment.substring(indexMar + 6, indexMar + 8);
                            }
                            else {
                                date = singleSegment.substring(indexMar + 6, indexMar + 7);
                            }
                        }
                    }
                }

                // APRIL
                else if (singleSegment.contains("Apr")) {
                    months = "April";
                    int indexApr = singleSegment.indexOf("Apr");
                    if (Character.isDigit(singleSegment.charAt(indexApr + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexApr + 5))) {
                            date = singleSegment.substring(indexApr + 4, indexApr + 6);
                        }
                        else {
                            date = singleSegment.substring(indexApr + 4, indexApr + 5);
                        }
                    }
                    if (singleSegment.contains("April")) {
                        indexApr = singleSegment.indexOf("April");
                        if (Character.isDigit(singleSegment.charAt(indexApr + 6))) {
                            if (Character.isDigit(singleSegment.charAt(indexApr + 7))) {
                                date = singleSegment.substring(indexApr + 6, indexApr + 8);
                            }
                            else {
                                date = singleSegment.substring(indexApr + 6, indexApr + 7);
                            }
                        }
                    }
                }

                // MAY
                else if (singleSegment.contains("May")) {
                    months = "May";
                    int indexMay = singleSegment.indexOf("May");
                    if (Character.isDigit(singleSegment.charAt(indexMay + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexMay + 5))) {
                            date = singleSegment.substring(indexMay + 4, indexMay + 6);
                        }
                        else {
                            date = singleSegment.substring(indexMay + 4, indexMay + 5);
                        }
                    }
                }

                // JUNE
                else if (singleSegment.contains("Jun")) {
                    months = "June";
                    int indexJun = singleSegment.indexOf("Jun");
                    if (Character.isDigit(singleSegment.charAt(indexJun + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexJun + 5))) {
                            date = singleSegment.substring(indexJun + 4, indexJun + 6);
                        }
                        else {
                            date = singleSegment.substring(indexJun + 4, indexJun + 5);
                        }
                    }
                    if (singleSegment.contains("June")) {
                        months = "June";
                        indexJun = singleSegment.indexOf("June");
                        if (Character.isDigit(singleSegment.charAt(indexJun + 5))) {
                            if (Character.isDigit(singleSegment.charAt(indexJun + 6))) {
                                date = singleSegment.substring(indexJun + 5, indexJun + 7);
                            }
                            else {
                                date = singleSegment.substring(indexJun + 5, indexJun + 6);
                            }
                        }
                    }
                }
                // JULY
                else if (singleSegment.contains("Jul")) {
                    months = "July";
                    int indexJul = singleSegment.indexOf("Jul");
                    if (Character.isDigit(singleSegment.charAt(indexJul + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexJul + 5))) {
                            date = singleSegment.substring(indexJul + 4, indexJul + 6);
                        }
                        else {
                            date = singleSegment.substring(indexJul + 4, indexJul + 5);
                        }
                    }
                    if (singleSegment.contains("July")) {
                        months = "July";
                        indexJul = singleSegment.indexOf("July");
                        if (Character.isDigit(singleSegment.charAt(indexJul + 5))) {
                            if (Character.isDigit(singleSegment.charAt(indexJul + 6))) {
                                date = singleSegment.substring(indexJul + 5, indexJul + 7);
                            }
                            else {
                                date = singleSegment.substring(indexJul + 5, indexJul + 6);
                            }
                        }
                    }
                }
                // AUGUST
                else if (singleSegment.contains("Aug")) {
                    months = "August";
                    int indexAug = singleSegment.indexOf("Aug");
                    if (Character.isDigit(singleSegment.charAt(indexAug + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexAug + 5))) {
                            date = singleSegment.substring(indexAug + 4, indexAug + 6);
                        }
                        else {
                            date = singleSegment.substring(indexAug + 4, indexAug + 5);
                        }
                    }
                    if (singleSegment.contains("August")) {
                        months = "August";
                        indexAug = singleSegment.indexOf("August");
                        if (Character.isDigit(singleSegment.charAt(indexAug + 7))) {
                            if (Character.isDigit(singleSegment.charAt(indexAug + 8))) {
                                date = singleSegment.substring(indexAug + 7, indexAug + 9);
                            }
                            else {
                                date = singleSegment.substring(indexAug + 7, indexAug + 8);
                            }
                        }
                    }
                }
                // SEPTEMBER
                else if (singleSegment.contains("Sep")) {
                    months = "September";
                    int indexSep = singleSegment.indexOf("Sep");
                    if (Character.isDigit(singleSegment.charAt(indexSep + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexSep + 5))) {
                            date = singleSegment.substring(indexSep + 4, indexSep + 6);
                        }
                        else {
                            date = singleSegment.substring(indexSep + 4, indexSep + 5);
                        }
                    }
                    if (singleSegment.contains("September")) {
                        months = "September";
                        indexSep = singleSegment.indexOf("September");
                        if (Character.isDigit(singleSegment.charAt(indexSep + 10))) {
                            if (Character.isDigit(singleSegment.charAt(indexSep + 11))) {
                                date = singleSegment.substring(indexSep + 10, indexSep + 12);
                            }
                            else {
                                date = singleSegment.substring(indexSep + 10, indexSep + 11);
                            }
                        }
                    }
                }
                // OCTOBER
                else if (singleSegment.contains("Oct")) {
                    months = "October";
                    int indexOct = singleSegment.indexOf("Oct");
                    if (Character.isDigit(singleSegment.charAt(indexOct + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexOct + 5))) {
                            date = singleSegment.substring(indexOct + 4, indexOct + 6);
                        }
                        else {
                            date = singleSegment.substring(indexOct + 4, indexOct + 5);
                        }
                    }
                    if (singleSegment.contains("October")) {
                        months = "October";
                        indexOct = singleSegment.indexOf("October");
                        if (Character.isDigit(singleSegment.charAt(indexOct + 8))) {
                            if (Character.isDigit(singleSegment.charAt(indexOct + 9))) {
                                date = singleSegment.substring(indexOct + 8, indexOct + 10);
                            }
                            else {
                                date = singleSegment.substring(indexOct + 8, indexOct + 9);
                            }
                        }
                    }
                }
                //NOVEMBER
                else if (singleSegment.contains("Nov")) {
                    months = "November";
                    int indexNov = singleSegment.indexOf("Nov");
                    if (Character.isDigit(singleSegment.charAt(indexNov + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexNov + 5))) {
                            date = singleSegment.substring(indexNov + 4, indexNov + 6);
                        }
                        else {
                            date = singleSegment.substring(indexNov + 4, indexNov + 5);
                        }
                    }
                    if (singleSegment.contains("November")) {
                        months = "November";
                        indexNov = singleSegment.indexOf("November");
                        if (Character.isDigit(singleSegment.charAt(indexNov + 9))) {
                            if (Character.isDigit(singleSegment.charAt(indexNov + 10))) {
                                date = singleSegment.substring(indexNov + 9, indexNov + 11);
                            }
                            else {
                                date = singleSegment.substring(indexNov + 9, indexNov+ 10);
                            }
                        }
                    }
                }
                // DECEMBER
                else if (singleSegment.contains("Dec")) {
                    months = "December";
                    int indexDec = singleSegment.indexOf("Dec");
                    if (Character.isDigit(singleSegment.charAt(indexDec + 4))) {
                        if (Character.isDigit(singleSegment.charAt(indexDec + 5))) {
                            date = singleSegment.substring(indexDec + 4, indexDec + 6);
                        }
                        else {
                            date = singleSegment.substring(indexDec + 4, indexDec + 5);
                        }
                    }
                    if (singleSegment.contains("December")) {
                        months = "December";
                        indexDec = singleSegment.indexOf("Dec");
                        if (Character.isDigit(singleSegment.charAt(indexDec + 9))) {
                            if (Character.isDigit(singleSegment.charAt(indexDec + 10))) {
                                date = singleSegment.substring(indexDec + 9, indexDec + 11);
                            }
                            else {
                                date = singleSegment.substring(indexDec + 9, indexDec = 10);
                            }
                        }
                    }
                }

                // Year Information
                if (singleSegment.contains(",")) {
                    int indexComma = singleSegment.indexOf(',');
                    year = singleSegment.substring(indexComma + 2, indexComma + 6);
                }
            }

            // FORMAT FOR ##/##/YYYY
            if (singleSegment.contains("/")) {
                for(int loop = 0; loop < singleSegment.length() - 1; loop++) {
                    if(singleSegment.charAt(loop) == ('/')) {
                        if(loop > 1) {
                            if(Character.isDigit(singleSegment.charAt(loop-1))) {
                                if(Character.isDigit(singleSegment.charAt(loop-2))) {
                                    if (date.equals("")) {
                                        date = singleSegment.substring(loop-2, loop); /*character Concatination*/
                                    }
                                    else if (!date.equals("") && (months.equals(""))) { // THE VALUE BELONGS TO MONTH
                                        months = singleSegment.substring(loop-2, loop); /*character Concatination*/
                                    }
                                    else if (!date.equals("") && !months.equals("")){ // THE VALUE BELONGS TO YEAR
                                        year = singleSegment.substring(loop + 1, loop + 5);
                                    }
                                }
                                else { // SINGLE-DIGIT
                                    if(date.equals("")) {
                                        date = singleSegment.substring(loop-1, loop);
                                    }
                                    else if (!date.equals("") && (months.equals(""))){
                                        months = singleSegment.substring(loop-1, loop);
                                    }
                                    else {
                                        year = singleSegment.substring(loop + 1, loop + 3);
                                    }
                                }
                            }
                        }
                    }
                }
            //}
        }

        //System.out.println(weekDay);
        //System.out.println("DATE: " + months + ", " + date);
        //System.out.println("YEAR: " + year);

        String formattedDate = year + "-" + months + "-" + date;
        return formattedDate;
    }

    public String getTime() {
        String hour = "", minute = "", amPm = "";
        //File inFile = new File(inputFileName);
        //Scanner inputFile = new Scanner(inFile);
        //while (inputFile.hasNext()) {
            String singleSegment = content;
            if (singleSegment.contains(":")) {
                int indexSemiColon = singleSegment.indexOf(":");
                if (indexSemiColon > 1) {
                    if (Character.isDigit(singleSegment.charAt(indexSemiColon - 1))) {
                        if (Character.isDigit(singleSegment.charAt(indexSemiColon - 2))) {
                            hour = singleSegment.substring(indexSemiColon - 2, indexSemiColon);
                            minute = singleSegment.substring(indexSemiColon + 1, indexSemiColon + 3);
                            amPm = singleSegment.substring(indexSemiColon + 4, indexSemiColon + 6);
                        }
                        else {
                            hour = singleSegment.substring(indexSemiColon - 1, indexSemiColon);
                            minute = singleSegment.substring(indexSemiColon + 1, indexSemiColon + 3);
                            amPm = singleSegment.substring(indexSemiColon + 4, indexSemiColon + 6);
                        }
                    }
                }
                else {
                    if (Character.isDigit(singleSegment.charAt(indexSemiColon - 1))) {
                        hour = singleSegment.substring(0,1);
                        minute = singleSegment.substring(indexSemiColon + 1, indexSemiColon + 3);
                        amPm = singleSegment.substring(indexSemiColon + 4, indexSemiColon + 6);
                    }
                }
            }
        //}
        // }
        // catch (IOException e) {
        //   System.out.println("Failed loading data.");
        //   e.printStackTrace();
        // } catch (FileNotFoundException e) {
        //   e.printStackTrace();
        // }

        //System.out.println("-----TIME-----");
        //System.out.println("HOUR: " + hour);
        //System.out.println("MINUTE: " + minute);
        //System.out.println("MORNING/AFTERNOON: " + amPm);

        String formattedTime = "T" + hour + ":" + minute + ":00-07:00";
        return formattedTime;
    }
}

package com.example.alishba.csvchecking;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {

    InputStream inputStream;

    public CSVReader(InputStream is) {
        this.inputStream = is;
    }

    //CSV file header
    private static final String [] FILE_HEADER_MAPPING = {"time","voltage"};

    //Student attributes
    private static final String ecg_time = "time";
    private static final String ecg_voltage="voltage";

    public  void readCsvFile() {
        ecg.ecgArrayList = new ArrayList<ecg>();
      //  FileReader fileReader = null;

        CSVParser csvFileParser = null;

        //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

        try {

            //Create a new list of student to be filled by CSV file data
           // List ecgs = new ArrayList();

            //initialize FileReader object
            //fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));


            //initialize CSVParser object
            csvFileParser = new CSVParser(reader, csvFileFormat);

            //Get a list of CSV file records
            List csvRecords = csvFileParser.getRecords();

            //Read the CSV file records starting from the second record to skip the header
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = (CSVRecord)csvRecords.get(i);
                //Create a new student object and fill his data
                ecg ec = new ecg(Float.parseFloat(record.get(ecg_time)), Float.parseFloat(record.get(ecg_voltage)));
                //ecgs.add(ec);
               ecg.ecgArrayList.add(ec);

                //new ecg(ecg_time,ecg_voltage
            }


        }catch(IOException ex) {
            throw new RuntimeException("Error in reading CSV file:" + ex);
        } finally {
            try{
               inputStream.close();

            } catch(IOException e) {
                throw new RuntimeException("Error while closing input stream: " + e);
            }
        }

    }

}
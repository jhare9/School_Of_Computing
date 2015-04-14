package edu.schoolapp.usm.jon.schoolofcomputing;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jon on 4/13/2015.
 */
public class file_reader {
     public file_reader(){}

     public String line_reader(Context context,int id){

         InputStream in = context.getResources().openRawResource(id);
         Scanner scan = new Scanner(in);

         StringBuilder sb = new StringBuilder();

         while(scan.hasNext()){
             sb.append(scan.nextLine()+" ");
         }

         scan.close();
         try {
             in.close();
         } catch (IOException e) {
             e.printStackTrace();
         }

         return sb.toString();
     }
}

package Online;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class LiveContest {
    int k=0;
    static String ctime[]=new String[100];
    static String cdate[]=new String[100];
    static String cname[]=new String[100];
    int mat[][]= new int[100][100]; 
   public void func(){
        database d=new database();
        String q1="select * from contest";
        d.opendb(q1, 2);
        if(d.c2==1){
            while(d.f!=false){
                try {
                    String nm=d.rs.getString("name");
                    String dt=d.rs.getString("start");
                    cname[k]=nm;
                    cdate[k]=dt;
                    String st=d.rs.getString("stime");
                    ctime[k]=st;
                    String arr[]= new String[3];
                    arr=st.split(":");
                    Integer a[]=new Integer[3];
                    
                    for(int i=0;i<3;i++){
                        a[i]=Integer.parseInt(arr[i]);
                        mat[k][i]=a[i];
                      
                    }
                   // Stopwatch s=new Stopwatch(a[2],a[1],a[0]);
                    d.f=d.rs.next();
                    k++;
                } catch (SQLException ex) {
                    Logger.getLogger(LiveContest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

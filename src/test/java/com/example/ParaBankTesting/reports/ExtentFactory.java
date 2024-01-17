package com.example.ParaBankTesting.reports;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {    // hacemos el metodo para instanciar el Reporte
    public static ExtentReports getInsance() {
        ExtentReports extentReports = new ExtentReports();
        //Sumamos info al reporte que vamos a crear, con esto creamos una pequeña tabla de como ejecutamos las pruebas
        extentReports.setSystemInfo("OS","Windows");
        extentReports.setSystemInfo("Navegador","Chrome");
        extentReports.setSystemInfo("Ambiente","QA");
        return extentReports;


    }
}

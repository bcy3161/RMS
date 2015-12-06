package com.nara.framework.util;

import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.rosuda.REngine.REXP;

import com.nara.apis.vo.Beta;
import com.nara.apis.vo.PairwiseTTest;
import com.nara.apis2.vo.Lda;

public class ControllerLogger {
	
	private static int LENGTH_OF_URL;
	
	/**
	 * dividerStart
	 *
	 * @author     YangHoon Jeon
	 * @since      2015-07-21
	 */
	public static void dividerStart(String URL) {
		LENGTH_OF_URL = URL.length();
		System.out.println("=============== Controller - "+URL+" ["+getCurDatetime()+"] ===============");
	}
	
	/**
	 * dividerEnd
	 *
	 * @author     YangHoon Jeon
	 * @since      2015-07-21
	 */
	public static void dividerEnd() {
		String retStr = "===================================================================";
		for(int i=0; i<LENGTH_OF_URL; i++)
			retStr += "=";
		System.out.println("\n" + retStr + "\n");
		LENGTH_OF_URL = 0;
	}

	/**
	 * getCurDatetime
	 *
	 * @author     YangHoon Jeon
	 * @since      2015-07-21
	 */
	private static String getCurDatetime() {
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return smf.format(new java.util.Date());
	}

	/**
	 * showValueObject
	 *
	 * @author     YangHoon Jeon
	 * @since      2015-07-21
	 */
	public static void showValueObject(Object object) {
		if(object instanceof com.nara.apis.vo.PairwiseTTest) showPairwiseTTest((PairwiseTTest) object);
		else if(object instanceof com.nara.apis.vo.Beta) showBeta((Beta) object);
		
		else if(object instanceof com.nara.apis2.vo.Lda) showLda((Lda) object);
	}
	
	/**
	 * showPairwiseTTest
	 *
	 * @author     YangHoon Jeon
	 * @since      2015-07-21
	 */
	private static void showPairwiseTTest(PairwiseTTest pairwiseTTest) {
		System.out.println("[LOG] VO - pairwiseTTest");
		
		System.out.println("      [isSubmit] : " + pairwiseTTest.isSubmit());
		System.out.println("      [getMenu_id] : " + pairwiseTTest.getMenu_id());
		System.out.println("      [getFileName] : " + pairwiseTTest.getFileName());
		System.out.println("      [getFileHeader] : " + pairwiseTTest.getFileHeader());
		System.out.println("      [getfileHeaderSize] : " + pairwiseTTest.getFileHeaderSize());
		System.out.println("      [getUploadedFile] : " + pairwiseTTest.getUploadedFile());
		System.out.println("      [getX] : " + pairwiseTTest.getX());
		System.out.println("      [getG] : " + pairwiseTTest.getG());
		System.out.println("      [getP_adj] : " + pairwiseTTest.getP_adj());
		System.out.println("      [getPool_sd] : " + pairwiseTTest.getPool_sd());
	}
	
	/**
	 * showBeta
	 *
	 * @author     YangHoon Jeon
	 * @since      2015-08-25
	 */
	private static void showBeta(Beta beta) {
		System.out.println("[LOG] VO - beta");
		
		System.out.println("      [isSubmit] : " + beta.isSubmit());
		System.out.println("      [getMenu_id] : " + beta.getMenu_id());
		System.out.println("      [getMode] : " + beta.getMode());
		System.out.println("      [getFileName] : " + beta.getFileName());
		System.out.println("      [getX_seq_from] : " + beta.getX_seq_from());
		System.out.println("      [getX_seq_to] : " + beta.getX_seq_to());
		System.out.println("      [getX_seq_length] : " + beta.getX_seq_length());
		System.out.println("      [getShape1] : " + beta.getShape1());
		System.out.println("      [getShape2] : " + beta.getShape2());
	}
	
	/**
	 * showLda
	 *
	 * @author     YangHoon Jeon
	 * @since      2015-10-14
	 */
	private static void showLda(Lda lda) {
		System.out.println("[LOG] VO - lda");
		
		System.out.println("      [isSubmit] : " + lda.isSubmit());
		System.out.println("      [getMenu_id] : " + lda.getMenu_id());
		System.out.println("      [getFileName] : " + lda.getFileName());
		System.out.println("      [getFileHeader] : " + lda.getFileHeader());
		System.out.println("      [getFileHeaderSize] : " + lda.getFileHeaderSize());
		System.out.println("      [getUploadedFile] : " + lda.getUploadedFile());
		System.out.println("      [getX] : " + lda.getX());
		if(lda.getGrouping() != null)
			for(int i=0; i<lda.getGrouping().length; i++)
				System.out.println("      [getGrouping("+i+")] : " + lda.getGrouping()[i]);
	}

	/**
	 * showREXP
	 *
	 * @author     YangHoon Jeon
	 * @since      2015-07-21
	 */
	public static void showREXP(String[] pName, REXP ... rExps) {
		if(pName.length != rExps.length)
			System.out.println("");
		else {
			for(int i=0; i<rExps.length; i++) {
				if(i == 0) System.out.print("[R] ");
				else System.out.print("    ");
				System.out.println(pName[i] + " : " + rExps[i]);
			}
		}
		System.out.println();
	}

	/**
	 * showRValues
	 *
	 * @author     YangHoon Jeon
	 * @since      2015-07-21
	 */
	public static void showRValues(String[] pTypes, String[] pNames, Object ... rValues) {
		for(int i=0; i<rValues.length; i++) {
			if(i == 0) System.out.print("[R] ");
			else System.out.print("    ");
			
			if(pTypes[i].equals("double[]")) {
				System.out.print(pNames[i] + " : " );
				double[] dArray = (double[]) rValues[i];
				for(int j=0; j<dArray.length; j++) {
					System.out.print(dArray[j]+" ");
				} System.out.println();
			} else if(pTypes[i].equals("String[]")) {
				System.out.print(pNames[i] + " : " );
				String[] sArray = (String[]) rValues[i];
				for(int j=0; j<sArray.length; j++) {
					System.out.print(sArray[j]+" ");
				} System.out.println();
			} else
				System.out.println(pNames[i] + " : " + rValues[i]);
		}
		System.out.println();
	}
	
}
package com.autodeskTestscripts;

public class Temproary {
public static void main(String[] args) {

String s="welcome";
String rev=" ";
char ch[]=s.toCharArray();
for(int i=ch.length-1;i>0;i--) {
	rev=rev+ch[i];
}
System.out.println(rev);
}
}

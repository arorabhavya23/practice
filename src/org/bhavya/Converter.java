//package org.bhavya;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class Converter {
//
//
//  Map<String, List<Employee>> lookupTable = new HashMap<>();
//  List<Employee> duplicateEmployee = new ArrayList<>();
//  public List<Employee> convertToEmployee(Message message){
//    List<Employee> NonDplicateEmp = new HashSet<>(duplicateEmployee).stream().collect(Collectors.toList());
//    List<Employee> NonDplicateEmps = new HashSet<>(duplicateEmployee).stream().collect(Collectors.toList());
//
//
//
//  }
//
//}
//
//class Message {
//
//  public String getTransactionId() {
//    return TransactionId;
//  }
//
//  public void setTransactionId(String transactionId) {
//    TransactionId = transactionId;
//  }
//
//  private String TransactionId;
//  private String AccountCode;
//  private String AccountType;
//}

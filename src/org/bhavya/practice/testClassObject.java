//package org.bhavya.practice;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.TreeSet;
//import org.bhavya.Employee;
//
////ThisIsForHarman
////namraHroF..
//// reverse the string without inbuild methods
//public class testClassObject {
//
//  private static String reverseString(String inputString){
//    // charAt(last index)
//    StringBuilder revresedString = new StringBuilder();
//    var i = inputString.length();
//    while(i >0 ){
//      revresedString.append(inputString.charAt(--i));
//    }
//    return revresedString.toString();
//  }
//
//  public static void main(String[] args) {
//    System.out.println(reverseString("ThisIsForHarman"));
//  }
//
//  //logest substring for unique charaters
//  // aaebxyaz
//  // aebxyz
//  private static String longestSubstring(String inputString){
//    List<Character> myCharList = new ArrayList<>();
//    var i = 0;
//    while(i < inputString.length() ){
//     myCharList.add(inputString.charAt(i));
//    }
//    //add to a set
//    // if it dosent add up restart the loop and save the size and substring
//    // return the max sized substring
//
//    var maxLen = 0;
//    var charSet = new TreeSet<Character>();
//    var tempStart = 0;
//    for(var j = 0; j < myCharList.size(); j++){
//      if(! charSet.add(myCharList.get(i))){
//
//        maxLen = maxLenmaxLen = j - tempStart;
//
//      }
//    }
//  }
//  @RestController
//  @Validated
//  class{
//
//
//
//  @Post(path = "/v1/updateEmployee", comsumes = "application/JSOn", pr)
//  public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody @valid Employee employee){
//    return
//  }
//
//  @Get("/v1/getEmployee/{id}?name=")
//    public ResponseEntity<Employee> getEmployeeDetails(@pathVariable @Valid UUID id){
//      // cal service to get the employee details
//      return Employee;
//    }
//  }
//
//  kafka ressilent by rocks publication
//  collection by durgasoft
//  Springboot in action
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}

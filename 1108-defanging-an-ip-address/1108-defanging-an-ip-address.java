class Solution {
    public String defangIPaddr(String address) {
        int length=address.length();
        String result="";
        //use replace function in string
        result= address.replace(".","[.]");
        
    return result;
    }
}
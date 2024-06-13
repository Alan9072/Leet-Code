class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String senten = "";
        String abc[] = sentence.split(" ");
        for(int i=0;i<abc.length;i++){
            for(int j=0;j<dictionary.size();j++){
                String elem = dictionary.get(j);
                if(abc[i].length()<elem.length())continue;
                if(abc[i].substring(0,elem.length()).equals(elem)){
                    abc[i] = elem;
                }
            }
        }
     for(int i=0;i<abc.length;i++){
        if(i == abc.length - 1){
            senten +=abc[i];
        }
        else{
            senten +=abc[i]+" ";
        }
        
     }
     return senten;
    }
}

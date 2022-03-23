package Przyklad02;

public class Main {
    public static void main(String[] args) {
        // ENUM jako klasa
        Type t = Type.byName("B");
        System.out.println(t);
    }

    public enum Type
    {
        A(1, "A"),
        B(2, "B"),
        C(3, "C");
        private int id;
        private String name;

        Type(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        public int getId()
        {
            return id;
        }
        public String getName(){
            return name;
        }
        public static Type byName(String name)
        {
//            for(Type el : values()){
//                if(el.getName().equals(name))
//                    return el;
//            }

            switch(name){
                case "A":
                    return A;
                case "B":
                    return B;
                case "C":
                    return C;
                default: return null;
            }
        }
    }
}
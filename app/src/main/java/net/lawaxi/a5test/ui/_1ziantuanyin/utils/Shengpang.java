package net.lawaxi.a5test.ui._1ziantuanyin.utils;

public class Shengpang {
    private String name;
    private boolean containItself;
    private boolean single = false;
    private boolean isHalf = false;
    private String[] contains;

    public Shengpang(String name, boolean containItself, String[] contains, boolean isHalf){
        this.name = name;
        this.containItself = containItself;
        this.contains = contains;
        this.isHalf = isHalf;
    }

    public Shengpang(String name, boolean containItself, String[] contains){
        this.name = name;
        this.containItself = containItself;
        this.contains = contains;
    }

    public Shengpang(String name){
        this.name = name;
        single = true;
    }

    public boolean contain(String a){
        if(single)
            return a.equals(name);

        if(containItself && a.equals(name))
            return true;

        if(a.equals("[") || a.equals(",") || a.equals(" ") || a.equals("]"))
            return false;
        for(String a1:contains){
            if (a1.equals(a))
                return true;
        }
        /*
        if (contains.toString().contains(a))
                return true;*/
        return false;
    }

    public String getName(){
        return name;
    }

    public boolean isSingle(){
        return  single;
    }

    public boolean isHalf(){
        return isHalf;
    }
}

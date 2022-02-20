package net.lawaxi.a5test.ui._2lauguoyin.utils;

public class common {
    private static final boolean _isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
    //引自https://www.iteye.com/blog/javapub-680793

    public static final boolean isChinese(char c){
        if(c == '《' || c == '》' || c=='，' || c=='。' || c=='？' || c=='！' || c=='【' || c=='】' || c=='（' || c=='）'
        || c=='“' || c=='”')
            return false;
        else return _isChinese(c);
    }

}

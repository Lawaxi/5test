package net.lawaxi.a5test.ui._1ziantuanyin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.spreada.utils.chinese.ZHConverter;

import net.lawaxi.a5test.R;
import net.lawaxi.a5test.ui._1ziantuanyin.utils.Shengpang;

import java.util.ArrayList;
import java.util.List;

public class _1Fragment extends Fragment {

    public static final ArrayList<Shengpang> data = new ArrayList<>(); //utils

    private View root; //控件
    private EditText text;
    private TextView show;

    private Runnable s; //搜索程序
    private static int count = 0;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.fragment_ziantuanyin, container, false);

        text = (EditText) root.findViewById(R.id.shit);
        show = (TextView) root.findViewById(R.id.q);
        s = new Runnable() {
            @Override
            public void run() {

                List a = ZTYhandle(text.getText().toString());

                Message msg = new Message();
                Bundle data = new Bundle();
                data.putString("a", (String) a.get(0));
                data.putString("b", ((ArrayList) a.get(1)).toString().substring(1, ((ArrayList) a.get(1)).toString().length() - 1).replace(", ", ""));
                if (((ArrayList) a.get(2)).isEmpty())
                    data.putBoolean("containsHalf", false);
                else {
                    data.putBoolean("containsHalf", true);
                    data.putString("c", ((ArrayList) a.get(2)).toString().substring(1, ((ArrayList) a.get(2)).toString().length() - 1).replace(", ", ""));
                }
                msg.setData(data);
                handler.sendMessage(msg);
            }
        };

        ((Button) root.findViewById(R.id.ybb)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(s).start();
            }
        });

        ((Button) root.findViewById(R.id.clear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
            }
        });

        //默認文字
        count++;
        if (count % 3 == 0)
            text.setText("中国人民也绝不允许任何外来势力欺负、压迫、奴役我们，谁妄想这样干，必将在14亿多中国人民用血肉筑成的钢铁长城面前碰得头破血流！");
        else
            text.setText("及即欺七喜洗句聚去趣虚需");

        return root;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle data = msg.getData();
            text.setText(data.getString("a"));
            if (data.getBoolean("containsHalf"))
                show.setText("文本中涉及的聲旁及單字： " + data.getString("b") + "\n半尖半團聲旁: " + data.getString("c"));
            else
                show.setText("文本中涉及的聲旁及單字： " + data.getString("b"));

        }
    };

    public static List ZTYhandle(String pre) {
        String a = ZHConverter.convert(pre, ZHConverter.TRADITIONAL)
                .replace("覷", "覰")
                .replace("璿", "璇")
                .replace("濬", "浚")
                .replace("媫", "婕")
                .replace("浕", "濜")
                .replace("侭", "儘")
                .replace("琎", "璡")
                .replace("桪", "樳")
                .replace("褏", "袖")
                .replace("衺", "邪");

        ArrayList<String> found_sp = new ArrayList<>();
        ArrayList<String> found_hsp = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            String t = a.substring(i, i + 1);
            if (t.equals("[")) {
                i = i + 2;
                continue;
            } else if (t.equals("]")) {
                continue;
            }

            System.out.println(t);
            for (Shengpang datum : data) {
                if (datum.contain(t)) {
                    a = a.replace(t, "[" + t + "]");
                    if (datum.isHalf() && !found_hsp.contains("(" + t + "," + datum.getName() + ")"))
                        found_hsp.add("(" + t + "," + datum.getName() + ")");
                    else if (!datum.isHalf() && !found_sp.contains(datum.getName()))
                        found_sp.add(datum.getName());
                    i = i + 1;
                    break;
                }
            }
        }

        List<Object> q = new ArrayList<>();
        q.add(a);
        q.add(found_sp);
        q.add(found_hsp);

        return q;
    }

    public static final void initData() {
        addDatum("脊", true, new String[]{"塉", "嵴", "𡲺", "𢊌", "𢱣", "膌", "𣖷", "𣦒", "𦵾", "瘠", "鹡", "𥕂", "蹐", "𦡠", "𩴎", "𩮦", "鶺", "𩺀", "𮭉"});
        addDatum("齊", true, new String[]{"齍", "劑", "𪗅", "䶒", "䶓", "嚌", "懠", "擠", "濟", "隮", "𡣙", "𡽉", "𪗆", "𪤪", "𬪜", "㸄", "櫅", "璾", "臍", "齌", "𣋠", "𪗇", "𪗈", "𬀛", "𬩣", "𮊞", "䄢", "䍤", "癠", "穧", "𥐌", "𥖭", "𧞓", "𪗉", "𪗊", "𬹲", "艩", "薺", "蠐", "𧓉", "𪗋", "𪗌", "䜞", "躋", "齎", "𧾙", "𨣧", "鑇", "霽", "𪗍", "齏", "䮺", "鱭", "麡", "𪊆", "𪗏", "𧖊", "䶩"});
        addDatum("即", true, new String[]{"䳭", "𪠂", "唧", "𠨞", "𡖖", "𡷦", "𡸎", "𪪗", "𭅼", "𣌸", "𪺜", "堲", "揤", "𠨠", "𣹜", "䐚", "楖", "節", "𣩃", "𪡰", "𭅽", "𮔕", "𥠈", "莭", "蝍", "鲫", "𣁚", "莭", "𨂢", "䳭", "鯽", "𪃹", "癤", "擳", "蠞"});
        addDatum("疾", true, new String[]{"嫉", "愱", "𠹋", "𢞱", "𨕾", "槉", "𤌿", "𤖏", "𦶱", "蒺", "螏", "𧎿", "𧪠", "𧽑", "𮜆", "𨪏"});
        addDatum("祭", true, new String[]{"𠭫", "𨝋", "𨝠", "㗫", "㡜", "漈", "際", "𡻰", "𭏥", "𮉯", "摖", "暩", "磜", "𣘤", "𪹥", "穄", "𥉻", "䏅", "𬖴", "𧫕", "𨄊", "𨢵", "𨶫", "𬶭", "𮢻", "鰶", "𮂤"});
        addDatum("寂", true, new String[]{"𬿟", "漃", "𢠭", "𫴇"});
        addDatum("集", true, new String[]{"𠍱", "㗱", "㙫", "㠍", "㠎", "潗", "𡙸", "𢵸", "𦈜", "𮥢", "𣛜", "𦺴", "𪹯", "𪼛", "磼", "穕", "𭼫", "䌖", "𫋝", "𮝨", "鏶", "𫕱", "𭬲", "𮤣", "𨤹", "𫘂", "𪆐", "𮬏", "𮦂", "𩁱"});
        addDatum("咠", true, new String[]{"偮", "𠦫", "㣬", "湒", "缉", "𠶻", "𡎎", "𢜱", "𭍪", "䐕", "楫", "辑", "𥚶", "𭦱", "𭵓", "䁒", "𥠋", "箿", "緝", "葺", "𧎎", "𫃇", "諿", "輯", "𧤏", "鍓", "𡁢", "䩰", "𭋷", "𩹫", "𪔪", "戢", "濈"});
        addDatum("七", true, new String[]{"柒", "𢍺", "切", "𭃃", "㲺", "𠮟", "𭗺", "𣎽", "𥤥", "𦉱", "𬻎", "𬂥", "𨳍", "𨾅", "𤶮", "𩫷", "𬙞", "𬴽", "𩵐", "𩾔", "𩾙", "𮅗",
                "沏", "𠯦", "𢗠", "𢗧", "𢪃", "𭎄", "𮤺", "𣐆", "𤆻", "𬍔", "䀙", "砌", "窃", "苆", "𥾛", "𦕀", "𫊧", "𮅀", "䟙", "𨥓", "𨥔", "𩚦"});
        addDatum("妻", true, new String[]{"凄", "𠉯", "𨹷", "悽", "捿", "淒", "郪", "𪥼", "棲", "𫅆", "𬐢", "緀", "萋", "褄", "𠬎", "𫋂", "𫌿", "霋", "𨧬", "𨿩", "鶈", "𩸸", "𪗍"});
        addDatum("妾", true, new String[]{"𫍭", "㢺", "接", "淁", "𡞘", "𢜡", "𫲨", "椄", "𣮍", "𤗈", "𮌟", "𥇒", "𥏡", "𥟣", "𧚪", "𮀨", "菨", "𦁉", "𧌃", "𮋵", "踥", "𧩕", "𧱙", "𧳛", "𨨧", "𥪵", "鯜", "𪑗"});
        addDatum("戚", true, new String[]{"傶", "𠗼", "𡻕", "嘁", "墄", "慽", "𡠽", "𡻷", "𤠽", "𦈚", "𬴈", "慼", "槭", "𤨟", "𦟠", "𦸗", "磩", "𥉷", "𬭭", "𥼀", "𦄉", "𦪊", "𧐶", "𫖹", "𧫳", "𮙖", "鏚", "𩥼", "𪔯", "𥀻"});
        addDatum("桼", true, new String[]{"厀", "𬤘", "𭂜", "䣛", "漆", "𠻟", "膝", "𦸓", "𧜝", "𥣥", "𣠬", "𩺲", "𪄭"});
        addDatum("西", true, new String[]{"𧟢", "𨚹", "𪠧", "徆", "恓", "拪", "𡧳", "𡶼", "𢬣", "𤞏", "𬘟", "栖", "氥", "牺", "𠒓", "𤈇", "𤥒", "𥙘", "𦚵", "𬡸", "硒", "𤶈", "𤿢", "𧟪", "𧟫", "𬭄", "粞", "絤", "舾", "茜", "𦕩", "𧟭", "𬠂", "𧧍", "𨠴", "𬡹", "𮗆", "𫘊", "𪀹", "𪎢", "𫙘", "𧠁"});
        addDatum("析", true, new String[]{"唽", "淅", "𠵍", "惁", "晰", "晳", "椞", "𣨗", "𪻩", "𮞝", "皙", "𥇦", "𥓊", "菥", "蜥", "𥮥", "𥺚", "𩗱", "𪁻"});
        addDatum("徙", true, new String[]{"屣", "漇", "𢇌", "𢊚", "𢒩", "𢳜", "𫄳", "𣘩", "𣯪", "𥛨", "㿅", "𥊂", "縰", "蓰", "𫆎", "蹝", "𩌦"});
        addDatum("息", true, new String[]{"𨻁", "媳", "鄎", "𠺒", "𬳋", "㮩", "熄", "𦞜", "𪬤", "𫺱", "瘜", "𫺽", "蒠", "螅", "𠒸", "𥰝", "𦧯", "𦧰", "𧪩", "𨃡", "鎴", "𩔨", "𢥔", "𪃼", "𪄛", "𢥷"});
        addDatum("舄", true, new String[]{"㕐", "冩", "寫", "瀉", "潟", "𣚔", "磶", "𤺎", "䉣", "蕮", "𩍆"});
        addDatum("悉", true, new String[]{"僁", "𠞹", "㣰", "㴽", "𡡁", "𢴑", "𭔎", "𤎕", "𦸝", "𬛐", "窸", "䊝", "蟋", "𦄵", "𨄠", "𨎒", "鏭", "𢥒", "𬋚"});
        addDatum("犀", true, new String[]{"𠌬", "樨", "𡼧", "𥛹", "𦼗", "𪼟", "𤺳", "𧑷", "𨬯"});
        addDatum("枲", true, new String[]{"𣔗", "𦈒", "𭱠", "𢻙", "𣕘", "𣗺", "𣗻", "葈", "𣙂", "𦂅", "𦥅", "𨐠", "𠢺", "𣜨", "𨽿", "𣝜", "𦥐", "𣞟", "䢄", "𣟼", "𣟽", "𣠎", "𣠏"});
        addDatum("先", true, new String[]{"侁", "詵", "駪", "𠀡", "冼", "𠈣", "𠜎", "㧥", "䢾", "宪", "洗", "𢈇", "𢏡", "𢓠", "𢙝", "𤞓", "𫩱", "𬳽", "㪇", "㭠", "毨", "烍", "珗", "选", "𠒑", "𠒒", "𣭟", "𣭡", "𥙝", "𦭶", "㾌", "铣", "𠒛", "𥏋", "𥏌", "𥑻", "𫪕", "𭽧", "筅", "𠒣", "𠸛", "𠸜", "𡖬", "𢔬", "𦀈", "𭦞", "䚚", "跣", "酰", "𧠺", "𧱀", "𬇶", "銑", "𨴐", "𨾷", "𩇜", "𩛔", "𫤠", "𭀲", "𭀳", "𠒷", "𩒙", "𪞄", "𬚬", "𩣂", "𭀵", "𠓀", "𩶤", "𪀷", "𫤢", "𭀷", "𭀺"});
        addDatum("習", true, new String[]{"𨻸", "𨻿", "㗩", "㠄", "嶍", "漝", "𡏽", "𢄭", "𪦞", "㦻", "槢", "𣄹", "𣤊", "𣯥", "𣯮", "𤗨", "𤛊", "𦸚", "㿇", "𮊙", "䌌", "䒁", "𥱵", "𦒆", "𦒉", "𦗗", "𦧱", "𧐔", "謵", "𧢇", "𨄌", "霫", "鳛", "𨫧", "𩀦", "𮤡", "飁", "𩘴", "騽", "鰼", "𩁙", "𪄶"});
        addDatum("席", true, new String[]{"𠻊", "𭏖", "𫟊", "𥔷", "蓆", "褯", "𥱊", "𫏛", "𬋗", "𢅺"});
        addDatum("前", true, new String[]{"譾", "翦", "偂", "剪", "媊", "揃", "湔", "𠷁", "𡍽", "𢃬", "𣹅", "𩨊", "𪥗", "𭚿", "椾", "煎", "瑐", "𠞽", "𤋎", "𫆨", "𧛯", "箭", "糋", "翦", "葥", "𦂒", "𦑦", "𬠝", "𧪈", "鎆", "𩋳", "騚", "鬋", "𠠩"});
        addDatum("戔", true, new String[]{"濺", "籛", "俴", "𫑠", "㣤", "䧖", "帴", "淺", "𠵖", "𡍌", "𡸚", "𢈽", "𢯆", "牋", "𣂧", "𣮏", "𤖆", "𪸶", "碊", "𢧗", "𤷃", "𥟥", "𦋈", "箋", "綫", "𠽈", "𦈻", "𦎗", "𧗸", "𮋇", "諓", "賤", "踐", "𠒲", "𧣴", "𧮺", "𧶤", "錢", "𨵊", "餞", "馢", "𩋋", "𩤊", "𪏊", "𬷟", "𪘪"});
        addDatum("薦", true, new String[]{"瀳", "𧂑", "𥤆", "𧟆", "𦇩", "𧲛", "𨰂", "𨷳", "韉"});
        addDatum("韱", true, new String[]{"𫦟", "㡨", "孅", "攕", "瀸", "𡄑", "𡾺", "𢖝", "櫼", "殲", "𣰷", "𣱰", "𤒯", "𧃖", "䃸", "𤼋", "𥍀", "籤", "纖", "襳", "𨇦", "𨏪", "鑯", "𩆷", "𩟶", "𩉔", "𩰁", "𪖎", "韯", "瀐", "殱", "籖"});
        addDatum("千", true, new String[]{"㔓", "仟", "刋", "𠘴", "𠚲", "𢌙", "𬼈", "圱", "圲", "奷", "扦", "汘", "纤", "阡", "𠦅", "𠦋", "𭛜", "杄", "歼", "迁", "𢨮", "𣅌", "𤣳", "𬆼", "瓩", "钎", "𠦞", "𢆍", "𣥥", "𧘜", "𬑻", "𭾜", "粁", "芊", "𦥛", "𧗤", "𨹱", "𪜍", "𫇚", "𫧢", "𭅡", "兛", "谸", "𧮮", "𧺛", "𧿐", "釺", "𠦳", "𬔌", "𩡴", "𩵞", "𩾭", "𠃇", "𦼌", "𭐰"});
        addDatum("青", true, new String[]{"錆", "倩", "蒨", "凊", "请", "𠝜", "啨", "圊", "埥", "婧", "寈", "情", "掅", "清", "郬", "𡸺", "𢃢", "𢉑", "𨓽", "𩇕", "𫕸", "𬘬", "𬮬", "𭓉", "𭛯", "晴", "棈", "氰", "腈", "靓", "𣮛", "𤦭", "𩇖", "𩇗", "𭴼", "皘", "睛", "碃", "锖", "靖", "𤲟", "𧚫", "𩇘", "𩇙", "𩇚", "𩇛", "𫕹", "𫕺", "𬰗", "𬰘", "𮃇", "𮄄", "𮧃", "箐", "精", "綪", "聙", "菁", "蜻", "靘", "𦑊", "𦑖", "𩇜", "䝼", "䞍", "請", "輤", "靚", "𤎓", "𫏏", "靜", "鲭", "𨿬", "𩜎", "𩓨", "𩗼", "𩇠", "𫘋", "𬺚", "䴖", "鯖", "鶄", "𩇡", "𪂴", "𫕼", "𩇢", "鼱", "𩇣", "𫸎", "𩇤", "𩇥"});
        addDatum("尋", true, new String[]{"𠎅", "𠟢", "𨼔", "噚", "撏", "潯", "鄩", "𡑎", "𡼢", "𢒫", "攳", "樳", "燖", "璕", "𢿼", "𣎟", "𤛧", "𦠅", "𥖇", "𥢛", "蕁", "蟳", "襑", "𥳍", "𦅀", "𧫿", "𪿃", "鱘", "彠"});
        addDatum("泉", true, new String[]{"𪵿", "𠗯", "𨜩", "㟫", "湶", "缐", "𡎏", "𡺙", "𢝓", "𣸕", "𪡠", "𬯏", "𭒉", "楾", "瑔", "腺", "𣹻", "𮞰", "𣻮", "𤭯", "𤾌", "𥠘", "𬎺", "𬭣", "線", "葲", "𧍭", "𫇋", "𤀁", "𧪒", "𧼷", "𨡹", "𭚛", "䤼", "闎", "鳈", "𩘘", "𩩺", "𬉖", "騡", "𥣤", "鰁", "𬉨", "𬉯", "𬉱", "𭳾"});
        addDatum("羨", true, new String[]{"㵪", "𠿢", "𦆀"});
        addDatum("將", true, new String[]{"𠅵", "𫦔", "㢡", "墏", "奬", "嶈", "摪", "獎", "𪤖", "𫳻", "𭊟", "𭒝", "𭲎", "㯍", "槳", "漿", "𣩗", "𤍵", "𤨿", "𤖛", "𤴠", "𫌏", "䉃", "䒂", "蔣", "螿", "蹡", "醬", "𧽩", "𨄚", "𩝫", "𬦞", "𮠿", "鏘", "𨫥", "𩝴", "𩱑", "䵁", "鱂", "𪙝"});
        addDatum("象", true, new String[]{"像", "勨", "嶑", "𢄵", "𢇐", "𢐣", "𢠽", "𤡸", "𨖶", "𪮱", "𫮧", "橡", "𤩪", "𦺨", "𬂏", "𭩈", "𭶆", "𮂚", "𬙧", "𮃯", "蟓", "襐", "𫂤", "𧬛", "𫏡", "𬥌", "鐌", "𩞧", "𬥆", "𬶲", "𢒶", "𩕓", "鱌", "𧲜"});
        addDatum("秋", true, new String[]{"𠩾", "𨺹", "㡑", "啾", "媝", "愀", "揪", "湫", "𡟊", "𡥻", "𡺘", "𢃸", "𫐵", "𬘴", "𭖽", "𭛻", "揫", "楸", "湬", "煍", "𤋦", "𤧐", "𤧦", "锹", "鹙", "𥔍", "𮃚", "𮖝", "䎿", "篍", "萩", "蝵", "𦂎", "𧎐", "𫆉", "𮃢", "醔", "𧡣", "𧤙", "𧷂", "𨍊", "𨡲", "𪝲", "鍫", "鍬", "鳅", "𧇸", "𩄍", "𩝋", "鞦", "𩘌", "𬳠", "𮩦", "鬏", "鰍", "鶖", "𩹤", "𪃩", "𪍗", "䵸"});
        addDatum("肖", true, new String[]{"俏", "削", "诮", "𦚍", "𨛍", "宵", "屑", "峭", "帩", "悄", "消", "绡", "陗", "𡌔", "𡜽", "𡯩", "𢈭", "𢓮", "𤞚", "焇", "逍", "𢼼", "𢽐", "𣆺", "𣭱", "𤙜", "𥙬", "䇌", "痟", "睄", "硝", "销", "𤫾", "𤿨", "綃", "蛸", "𥹶", "𦐺", "𦓴", "誚", "踃", "𧣪", "𧳍", "𧶈", "𨡀", "𨲆", "𬹈", "銷", "霄", "𩛱", "𬺆", "鞘", "韒", "颵", "𩠦", "𩡈", "𩩓", "𬳘", "魈", "𮆂", "䴛", "𪁎", "𪌯", "𮝥", "𪑊", "𪘞"});
        addDatum("笑", true, new String[]{"㗛", "𡮜", "𢞖", "𢲑", "𫹠", "𣉧", "𬕓", "𭡻", "𧜕", "𧏣", "𮆂", "𫂪", "𫛎"});
        addDatum("且", true, new String[]{"伹", "刞", "县", "𫨶", "㚗", "䢸", "咀", "坥", "姐", "岨", "沮", "狙", "𢂈", "𢒉", "𬲭", "𭒽", "𭖍", "䏣", "𢨷", "𤇅", "𤇙", "𤔈", "𤕲", "𥘲", "𭁎", "𭭞", "𭷚", "疽", "砠", "罝", "𤱌", "𤿚", "𥥐", "𥩢", "𦊕", "𦊨", "𦊩", "𫸴", "𬬺", "𮀀", "祖", "笡", "耝", "苴", "蛆", "袓", "𡲂", "𬅿", "趄", "跙", "𡎬", "𡲤", "𧠢", "𧣞", "雎", "龃", "𪧠", "𫿇", "𭵞", "飷", "𧇇", "𧇈", "𩗃", "𩲲", "𬌒", "𭶴", "𮧊", "𬁫", "鴡", "𧇣", "覰", "𪐵", "𧇿", "𮮭", "齟", "𪗱", "𪽤"});
        addDatum("晉", true, new String[]{"𡦌", "𡺽", "𪬕", "戩", "𦵻", "𧎽", "𨍬", "𨫌", "搢", "縉", "瑨"});
        addDatum("盡", true, new String[]{"儘", "𪟖", "嚍", "壗", "嬧", "濜", "𢣺", "𪮺", "㯸", "燼", "璶", "𣃏", "藎", "𥵧", "贐", "𩟝", "𬬗", "𥃞"});
        addDatum("秦", true, new String[]{"溱", "嗪", "嫀", "𡏑", "𡻈", "𫮔", "𤚩", "𪜞", "𫀜", "𥉜", "螓", "𥱧", "𬛌", "𧤛", "𧽕", "𨪦", "𩌘", "𩘢", "𩥚", "𪄈", "𪒆"});
        addDatum("心", true, new String[]{"心", "芯", "沁", "吣"});
        addDatum("辛", true, new String[]{"薛", "莘", "𬨖", "𠉄", "㛙", "垶", "骍", "𢓫", "𣐽", "𨐍", "𨐎", "𬯁", "𭍤", "𭝅", "𭡄", "𣇛", "𣓀", "𤈼", "𤙡", "𦛛", "𨐏", "𨐑", "𬍧", "𬨘", "锌", "𤽮", "𥏔", "𥞽", "𨐒", "𨐓", "𪿢", "𫐚", "𬨗", "𬨙", "𥭴", "𦀓", "𦐹", "𧗶", "𨐔", "𨐕", "𨐖", "𨐗", "𫋁", "𫐛", "𮇞", "辞", "䛨", "觪", "𦑒", "𧱏", "𨁅", "𨌍", "𨐘", "𨐙", "𨐚", "𨐛", "𬪬", "鋅", "𤨘", "𨐜", "𨐝", "𨐞", "𨴲", "𮝼", "辥", "𨐠", "𨐡", "𨐣", "𨐤", "𨐥", "𨐦", "𮧝", "𮨬", "騂", "𥋑", "𨐩", "𨐪", "𨐮", "𩷔", "𮝽", "𨐶", "𨐷", "𨐸", "𨐺", "𫐝", "𫓅", "𨐿", "𬨛"});
        addDatum("卂", true, new String[]{"讯", "汛", "阠", "𤜢", "㭄", "迅", "𣥇", "𤣲", "𤬫", "𥃴", "𥝡", "䒖", "𠫲", "𧈲", "訊", "軐", "𧮬", "𧿅", "𪜖", "㷀", "茕", "𨾑", "𣈟", "𤽰", "𩑓", "𩖜", "𩨖", "煢", "𩡰", "𩡵", "𦧾"});
        addDatum("井", true, new String[]{"丼", "𠀎", "㓝", "讲", "𠦈", "𨙷", "𨸥", "𭅆", "㘫", "坓", "妌", "宑", "汫", "阱", "𠛝", "𠯤", "𢒈", "𢪝", "𣲜", "𪪁", "𬜣", "𭃎", "㐩", "汬", "肼", "进", "𣂗", "𣏨", "𣥞", "𣥟", "𪰉", "𪱶", "𫡳", "𬼾", "穽", "𥐹", "𥝷", "𬑽", "𭾞", "𭾠", "𡖚", "𥬆", "𦧏", "𬆓", "𬙍", "𬟷", "𮈃", "𠄺", "𠭘", "𫎁", "𬪦", "𮗻", "𣸕", "𨥙", "𨳩", "𤌌", "𩾺", "𣊼", "𨐨", "𪔏"});
        addDatum("星", true, new String[]{"𬀶", "𬾰", "惺", "猩", "𡟙", "𬴄", "𭈻", "𭡦", "暒", "煋", "瑆", "腥", "𠬋", "𣨾", "𣮶", "𪻹", "𭦷", "𮂇", "睲", "𥠀", "𧛟", "篂", "𦎬", "𦖤", "𦩠", "𪞃", "謃", "醒", "𣋀", "𧡶", "𪱊", "𫎻", "𬁖", "𭧰", "𭧻", "𮛲", "𨩛", "𩄆", "𬁚", "𬉚", "𬶢", "𭧼", "𣋮", "𪱎", "𭨅", "𮩥", "𩤵", "鯹", "𣌌", "𫠛", "𣌜"});
        addDatum("就", true, new String[]{"僦", "㠇", "㩆", "殧", "𤎼", "𤏅", "𦠢", "𪼝", "鹫", "𥳛", "𧑙", "𮕀", "𧫾", "𫎢", "𮚦", "𩀻", "鷲", "𪆩"});
        addDatum("酋", true, new String[]{"𠄁", "𨜟", "𨺧", "㥢", "崷", "揂", "湭", "𡞜", "𡯾", "𡲚", "𡺚", "𢉷", "𢍜", "𪡧", "𬘶", "㷕", "煪", "遒", "𣣫", "𣮩", "𤋃", "𦝱", "𦳷", "𬨎", "𤸈", "緧", "蝤", "𦖣", "𦩲", "𮉶", "趥", "𧤕", "𧳫", "𨡴", "𨢅", "𨢈", "𨩊", "𫜟", "鞧", "𩔕", "𮡂", "𩮈", "𮡃", "䲡", "鰌", "𨣡", "𪃬", "𪍑", "蠤", "𪓰", "𪓵"});
        addDatum("囚", true, new String[]{"𠧚", "泅", "𢘄", "𨒊", "𭛢", "𠉁", "𣐮", "𣧝", "𣭃", "𪸜", "𥁕", "𬑋", "苬", "𧣕", "𨥱", "𮨃", "鮂"});
        addDatum("羞", true, new String[]{"馐", "𤨩", "𦟤", "𥀞", "𦪋", "𬖱", "饈", "𩘭", "鱃", "𪅠", "𫅡", "𬚂"});
        addDatum("脩", true, new String[]{"滫", "𭢎", "樇", "𤛛", "𥉈", "𥠿", "𦃬", "𮆀", "鏅", "𪅭"});
        addDatum("修", true, new String[]{"𡟞", "𢟅", "𣺫", "𫝽", "𭉫", "𡪇", "𣘀", "𥈌", "𦤜", "𥱤", "𬗲", "𬠡", "鎀", "𩝧", "𫙯"});
        addDatum("秀", true, new String[]{"𠃯", "𠉑", "𨹳", "绣", "𢓵", "𢭆", "𣵛", "𪣜", "𫵿", "𮂼", "琇", "𣒴", "𣮁", "𤥹", "𥙾", "𬊔", "锈", "𤯪", "𥏗", "𧚘", "𮀞", "綉", "銹", "𨴷", "𥢁", "𮪆", "𪁮", "𥣧", "𥤃", "璓"});
        addDatum("取", true, new String[]{"𠉧", "𨛿", "埾", "娵", "娶", "𡱾", "𡸘", "𡸨", "𢃣", "𢈾", "𢛏", "𢮝", "𣷗", "𨓭", "𪪿", "𭰮", "𮉪", "𤔛", "𤕖", "𤚉", "𤦟", "𦕪", "𦝒", "𪞔", "𪺐", "𭴻", "最", "𤭡", "𥦡", "𥪏", "𧚥", "𧚿", "聚", "𦁫", "𧌗", "𫃂", "𫩉", "𭒒", "趣", "𣍇", "𥧖", "𦖰", "𧩞", "𧱛", "𫮣", "𬥁", "𮗕", "𠮊", "𠮋", "𪠱", "𦗘", "𩋄", "𮪊", "𪋄", "𮕉", "𪘸"});
        addDatum("胥", true, new String[]{"偦", "谞", "𭂘", "㥠", "壻", "婿", "揟", "湑", "𡹲", "𤟠", "𩠋", "楈", "𥚩", "𬨏", "稰", "𤸀", "糈", "縃", "蝑", "諝", "醑", "𦠷", "𧶳", "𨍐", "𩝔", "𩾊", "𮢦", "䱬", "𪙀"});
        addDatum("須", true, new String[]{"嬃", "𠾫", "𢄼", "𢊼", "澃", "𣛪", "𩒹", "盨", "𩓾", "蕦", "𥳗", "𦄼", "𦅓", "𮖶", "𨅑", "𢒷", "𨬗", "𩅺", "𩔾", "𣌌", "鬚", "𪆦"});
        addDatum("序", true, new String[]{"𨹘", "垿", "𡜾", "𢭸", "𦯅", "𫸉"});
        addDatum("全", true, new String[]{"醛", "佺", "诠", "𠛮", "𠤹", "𨛈", "𨹑", "姾", "峑", "恮", "洤", "𠱴", "𡋄", "𢂘", "𩧴", "𬘥", "烇", "牷", "辁", "𠓰", "𪞇", "𪰡", "䀬", "痊", "硂", "铨", "𮁵", "筌", "絟", "荃", "𦓰", "𧊲", "𫆂", "𫤪", "詮", "跧", "輇", "𠓴", "𧻤", "銓", "𠓹", "𠓻", "𪼈", "𫗐", "𫣝", "𫗽", "駩", "𠓾", "𣁦", "𦦮", "𫤍", "𬣎", "𨇎"});
        addDatum("爵", true, new String[]{"𠘣", "𫤼", "㩱", "灂", "嚼", "𢥚", "𫸤", "㬭", "爝", "𦣅", "䂃", "皭", "𭚞", "𥷮", "𮉜", "𮍟", "釂", "𨇺", "𨰜", "𬺖", "𬋺", "𫑲", "𪚅"});
        addDatum("雪", true, new String[]{"𠞯", "𪞵", "𠽌", "𡐅", "𡠭", "𢳬", "𫕣", "𬝹", "樰", "膤", "𤍱", "𩃏", "𬎅", "艝", "𫃽", "𫟀", "轌", "鳕", "𩅷", "𫂪", "鱈", "𨯎", "𤓨"});
        addDatum("巽", true, new String[]{"㔵", "𬤥", "噀", "𡢀", "𡮭", "𢵬", "𦈝", "㷷", "選", "𤩄", "𦠆", "𦺈", "𦌔", "䍻", "繏", "𡮸", "䠣", "𧾌", "鐉", "𦧸", "𪟼", "𩪞", "𩦖", "𩻝"});
        addDatum("昔", true, new String[]{"鵲", "碏", "昔", "耤", "䣢", "𤁏", "藉", "籍", "𨆮", "踖", "惜", "借", "唶"});
        addDatum("夕", true, new String[]{"汐", "矽", "穸"});
        addDatum("夋", true, new String[]{"濬", "俊", "𠗕", "𠣟", "𨛐", "𭐤", "埈", "峻", "悛", "浚", "陖", "馂", "骏", "𡱥", "𢈡", "𢏤", "𢓭", "𭖨", "𭘁", "晙", "朘", "焌", "逡", "𠅣", "𡕧", "𡕬", "𥚂", "𭦕", "𭯚", "畯", "稄", "竣", "𤽭", "𥍬", "𧚉", "𭽫", "𠨢", "𠬌", "𥭟", "𦀷", "𦑁", "𦑂", "𦫝", "𭐩", "𮋰", "𮔖", "䞭", "賐", "𠬍", "𨌘", "𭐪", "㕙", "鋑", "𨿓", "餕", "𩈥", "𩊻", "𩓀", "駿", "𩰺", "鵔", "鵕", "𪊴", "𮭬", "黢", "𮇾", "𪕞", "𪘑"});
        addDatum("旋", true, new String[]{"璿", "嫙", "漩", "𢄲", "𢕐", "𢳄", "𩠍", "㯀", "暶", "璇", "𣎓", "𭥄", "䁢", "镟", "𥪱", "𧜽", "䗠", "縼", "蔙", "𧐗", "鏇", "𩘶", "䲂", "𪍧"});
        addDatum("循", true, new String[]{"𣛝", "𧝩", "𦅑"});
        addDatum("亲", true, new String[]{"親", "新", "薪", "媇"});
        addDatum("囟", true, new String[]{"䛜", "㭡", "薪", "媇"});
        addDatum("\uD842\uDF36", true, new String[]{"寢", "祲", "㓎", "侵", "𠜘", "唚", "埐", "浸", "骎", "𡨞", "𢔀", "𢬶", "𭆰", "梫", "𢽖", "𣆲", "𦯈", "𭴵", "𭷆", "𭹔", "㾛", "锓", "𥆷", "𥍯", "𮃆", "𮄀", "綅", "𥺑", "誛", "𨡉", "𮛟", "鋟", "𩒸", "駸", "鮼", "𪖧"});
        addDatum("鬵", true, new String[]{"𨽨", "灊", "𣠟"});
        addDatum("宿", true, new String[]{"𠍊", "𢳔", "𪩻", "𫫠", "𫺿", "𡪴", "𣩐", "𤛝", "𦟱", "𥀝", "𥕯", "𫔊", "蓿", "𥼍", "𧐴", "𨢲", "鏥", "𨣡", "𩐼", "𩘰", "𩥿"});
        addDatum("省", true, new String[]{"𨜜", "㨘", "𡞞", "𡨽", "𢜫", "𭖶", "㮐", "𣦉", "𦳗", "𪻻", "𫆦", "𪾱", "𫵆", "箵", "𦔄", "𧍖", "𨲓", "𫍂", "𨩠", "𨵥", "𩩭", "𪱐", "𬥇"});
        addDatum("喿", true, new String[]{"僺", "劋", "𠟯", "𫥛", "𬤨", "幧", "缲", "𤢖", "𪤢", "𢻥", "𢿾", "𣀉", "𣋝", "𣜣", "𣰕", "𦾈", "𩙰", "𡂟", "𥖨", "繰", "𥼾", "𦏛", "𦗵", "𧒮", "𧴜", "鐰", "𩟎", "𫚫", "𫧭", "𩙈", "𩯟", "𮪚", "𪍻", "𪍽", "𥽹"});
        addDatum("燮", true, new String[]{"躞"});
        addDatum("鮮", true, new String[]{"㶍", "廯", "𡾮", "𢥌", "𢹛", "𭗴", "𣟲", "癬", "䉳", "蘚", "𦇫", "𧕇", "𨇤", "𩆵"});
        addDatum("相", true, new String[]{"厢", "𪝋", "廂", "湘", "缃", "𠷹", "𪶛", "想", "𣕦", "𤧇", "𤭪", "𤷼", "箱", "緗", "葙", "𫝛", "𧡮", "𮘢", "𩮌", "𬴷", "𪂼"});

        addDatum("散", false, new String[]{"𠎭", "𠪣", "𠾎", "𢄻", "𢊰", "𤩀", "𦠐", "𦺻", "𪯗", "𥂪", "𥋌", "𧝠", "𫔌", "𧽾", "𨅖", "霰", "𮣂", "𪯝"});
        addDatum("嗇", false, new String[]{"𠎸", "𠟩", "𠢳", "墻", "嬙", "廧", "𡀁", "𡫆", "𭢲", "檣", "牆", "𢿿", "𤗼", "𤛷", "𥜎", "𬎓", "艢", "薔", "𧒗", "𬬋", "𩍙", "𩏫", "𩕡", "𩼒"});
        addDatum("肅", false, new String[]{"㔅", "𠏐", "嘯", "彇", "𡼣", "歗", "熽", "𪬵", "𫱷", "𦘤", "䊥", "簫", "繡", "蕭", "瀟", "蠨", "蟰", "𦪓", "𧑛", "𧽷", "𨅋", "𮋕", "鏽", "𬣉", "𩘹", "𮩰", "𪆭"});
        addDatum("疌", false, new String[]{"倢", "𨺇", "婕", "崨", "徢", "捷", "𡹈", "𢈻", "𢏵", "𢜀", "𣶏", "𤟃", "𨓰", "㫸", "脻", "𣄂", "𣓉", "𣮌", "𤙶", "𬍫", "睫", "𤲣", "𥓐", "𧚨", "緁", "𦑈", "𦩌", "誱", "踕", "𦑯", "𩃖", "𦦘", "𩗳", "𨤴", "𪖮"});
        addDatum("枼", false, new String[]{"偞", "𠗨", "𠝝", "媟", "屟", "渫", "𡺑", "𢜨", "𣓪", "𫄬", "𭪭", "𭸗", "䢡", "𣈽", "𣖦", "𤭴", "𥏭", "𥠓", "𬃯", "緤", "𥻈", "𦉃", "𫖷", "𭫮", "𮋶", "𧽅", "𨍕", "𨤘", "𫌣", "𨵳", "𩄓", "䭎", "鞢", "𩐱", "𩔑", "𩘏", "𩳶", "𬙾", "𪃸", "𪍐", "𧃹", "𪑧", "𮆩"});
        addDatum("爭", false, new String[]{"𠲜", "凈", "𨛰", "𬋨", "淨", "𡸵", "𢏰", "𢛵", "𫐭", "𡴣", "𦱊", "𪟐", "𪰭", "𪸾", "𪺓", "𠬉", "𠎈", "𥺲", "𦓺", "𨌢", "𨲌", "𪬭", "𪺗", "靜", "𤔷", "𦽰", "𩓞", "𩗲", "𨘱", "𪢛", "𫣺", "𧬦"});
        addDatum("䙴", false, new String[]{"遷", "僊", "躚", "韆", "褼", "𨝍", "𢕖", "𢳍", "𣻝", "𡼟", "𣘝", "𦸊", "𮂗", "𥱺", "蹮", "𦒘", "𫎾", "𩌕", "𪄷"});
        addDatum("責", false, new String[]{"漬", "勣", "𨖊", "𭍬", "𣤈", "𤖓", "𤗮", "𦟜", "磧", "積", "𤳎", "𤹠", "𥎍", "𥡯", "𧶷", "𭽴", "𮂒", "績", "襀", "𥼃", "𦎸", "𦣱", "𧐐", "䚍", "䟄", "蹟", "𨢦", "𨲪", "𩄾", "𫗙", "𮥜", "𩌪", "𩔳", "𫘁", "𮧐", "鰿", "𪄸", "𪒑", "䶦"});
        addDatum("亦", false, new String[]{"𠲔", "𢙕", "𫔱", "𫼬", "迹", "𢼜", "𤥂", "𦮰", "𫿳", "𬀳", "𬁢", "𭥼", "𭴢", "𣷖", "𧙡", "𬒵", "𠅯", "𥿹", "𧊤", "𬖛", "跡", "𡙩", "𧧩", "𨀶", "𫒚", "𩎭", "𩷉", "𪁂", "𪊳"});
        addDatum("四", false, new String[]{"伵", "呬", "怬", "𢏎", "𢪾", "𣳉", "𪯣", "𮕳", "𥹊", "𥿖", "𧣛", "𫪸", "駟"});
        addDatum("思", false, new String[]{"𠅤", "𠖓", "𢛥", "𨜐", "𨺯", "𫍰", "𤟧", "𪮏", "𭓑", "𢞨", "𢞰", "𤋘", "𢠞", "𤸛", "𦋮", "𫀼", "葸", "𥯨", "𥻏", "𦖷", "𦖻", "𦩭", "𧍤", "𧗂", "𬜉", "諰", "𨡾", "𢣢", "𦻇", "𪃄", "𭟜", "𪕳"});
        addDatum("易", false, new String[]{"𠴭", "𡱿", "𡸑", "𢃡", "𢒗", "𤟍", "𫶁", "𬀺", "𬪉", "𬯆", "𭕏", "焬", "𣂨", "𣓾", "𣨟", "𣱢", "𫀒", "𫾻", "𬊙", "𬊛", "𬻸", "𭶱", "𮌝", "锡", "𢾙", "𣈱", "𥍴", "𥓘", "𥚯", "𥟘", "𥪔", "𫨭", "𬙢", "𭽛", "緆", "裼", "𠖞", "𣉝", "𣉠", "𣉷", "𥮬", "𦓻", "𣋇", "𧩎", "𨲎", "𪱁", "𬁏", "𭧚", "錫", "𡀻", "𣊷", "𧼮", "𩃮", "𩛿", "𩋌", "𩗺", "𭧺", "𥂺", "𪎥", "𪎧", "𦦸", "𪕩", "𣌒"});
        addDatum("朁", false, new String[]{"僭", "𨼐", "嶜", "潛", "𡡖", "䐶", "橬", "熸", "𦻳", "𪯘", "䁮", "𥎑", "𧝆", "𣩳", "糣", "䤐", "𨅔", "𩀿", "𩅨", "鐕", "䭙", "𩻛", "𪅽", "𪖼"});
        addDatum("斬", false, new String[]{"𠌲", "𭄇", "㜞", "㟻", "塹", "漸", "𠼃", "𠼗", "𡐛", "𢄤", "槧", "𣊙", "𤍖", "𬆉", "𥕌", "𥪭", "蔪", "𦗚", "𦗝", "𧐮", "𮅼", "䟅", "𧴃", "𧽯", "𬧋", "鏩", "𩀧", "𩞏", "䭕", "𩈻", "𩴕", "䳻"});
        addDatum("延", false, new String[]{"𠈰", "涎", "𢚀", "𫄧", "𫷳", "𭖮", "𮥋", "𣆴", "𣇇", "𭦋", "𤥻", "𮁺", "𮃾", "𮣴", "𦕣", "𦧝", "𦋪", "𨁆", "𩃀", "䗺"});
        addDatum("舌", false, new String[]{"𦧆", "舏", "𫇔", "𡇜", "𡯢", "𦧇", "𭓯", "𮍴", "𮍵", "𢼤", "𣁳", "𣢯", "𣭪", "𤈏", "𦧈", "𦧉", "𦧊", "𦧋", "𦧌", "𦧍", "𦧎", "𦧏", "𦧐", "𭥹", "铦", "𤫵", "𤭇", "𥚇", "𦧑", "𦧒", "𦧓", "𦧔", "𬜅", "𬜆", "𮍶", "𮍷", "絬", "𦧖", "𦧗", "𦧘", "𦧙", "𦧚", "𦧛", "𦧜", "𦨯", "𬚸", "𬛥", "𬱠", "𦧝", "𦧞", "𧵳", "𨈸", "𫇖", "𬜇", "𮝐", "辞", "銛", "𦧟", "𦧠", "𦧡", "𦧢", "𦧣", "𦧤", "𦧥", "𦧦", "𫕛", "𫫞", "𬜈", "𬺄", "𣽰", "𦧧", "𦧩", "𦧪", "𦧫", "𦧬", "𩈙", "𬜉", "𬜊", "𬜌", "𬜍", "𮍺", "𮍻", "𮍼", "𮍽", "𮍾", "𮧺", "𦧭", "𦧮", "𦧯", "𦧰", "𫇗", "𦧱", "𦧲", "𧱳", "𪌩", "𪎾", "𫬎", "𬵏", "𦧴", "𬜎", "𦧷", "𫇘", "𬜏", "𬜐", "𪗽", "𦧺", "𦧻", "𦧼", "𮎀", "𦧽"});
        addDatum("隹", false, new String[]{"𠃲", "隽", "奞", "雀", "截",
                "熦", "𠻘", "𡦓", "𣼎", "𭗋", "𢧵", "𤍳", "𪾻", "𬑥", "𮀿", "𠓃", "𫋗", "𧽟", "𨄤", "𨫠", "𪅓", "𮭕", "𪖀", "巀", "𬿫", "𭗝", "𭞷", "𭢜", "璡",
                "𣛎", "𦻗", "𬔀", "䗯", "𥳟", "𧾄", "進", "璡",
                "焦", "僬", "劁", "谯", "𨝱", "𨿈", "噍", "嫶", "嶕", "嶣", "憔", "撨", "潐", "𢄺", "𨖵", "𨸋", "𨿞", "𭔓", "樵", "燋", "膲", "𣤚", "𥛲", "𭧭", "癄", "瞧", "礁", "鹪", "𧝈", "𨱓", "𪽢", "蕉", "蟭", "𥼚", "𦅃", "𦗠", "𦣳", "譙", "趭", "醮", "鐎", "𨶲", "䩌", "顦", "𣟼", "𩏢", "𩴧", "鷦", "𪆄",
                "暹"});
        addDatum("曳", false, new String[]{"𠈐", "洩", "𡜄", "𢂝", "𢘽", "𨒧", "𫲥", "㡼", "𤤺", "𦛈", "𤥟", "𤵺", "𧙟", "𭾫", "絏", "𡲝", "𥹞", "𦐪", "𦓕", "𧊣", "𠻇", "𡲭", "𧻭", "𨋯", "𨱽", "𫒗", "𤲼", "𩊒", "𩎥", "𧽇", "𧽈", "𩬲", "𪀕", "齥"});
        addDatum("枼", false, new String[]{"偞", "𠗨", "𠝝", "媟", "屟", "渫", "𡺑", "𢜨", "𣓪", "𫄬", "𭪭", "𭸗", "䢡", "𣈽", "𣖦", "𤭴", "𥏭", "𥠓", "𬃯", "緤", "𥻈", "𦉃", "𫖷", "𭫮", "𮋶", "𧽅", "𨍕", "𨤘", "𫌣", "𨵳", "𩄓", "䭎", "鞢", "𩐱", "𩔑", "𩘏", "𩳶", "𬙾", "𪃸", "𪍐", "𧃹", "𪑧", "𮆩"});
        addDatum("射", false, new String[]{"㓔", "谢", "㴬", "塮", "𢲌", "𤚑", "𤠭", "𫷺", "榭", "𥛖", "𭵪", "𡭉", "𧛼", "𪧻", "𪿎", "𬙥", "𥱈", "𧎭", "謝", "𬮏", "𩘧", "𬳢", "麝"});
        addDatum("爭", false, new String[]{"𠲜", "凈", "𨛰", "𬋨", "淨", "𡸵", "𢏰", "𢛵", "𫐭", "𡴣", "𦱊", "𪟐", "𪰭", "𪸾", "𪺓", "𠬉", "𠎈", "𥺲", "𦓺", "𨌢", "𨲌", "𪬭", "𪺗", "靜", "𤔷", "𦽰", "𩓞", "𩗲", "𨘱", "𪢛", "𫣺", "𧬦"});
        addDatum("由", false, new String[]{"𠃦", "𤰔", "𠔍", "𫔼", "届", "岫", "峀", "𠰬", "𠱋", "𡊡", "𡘊", "𡛽", "𡱋", "𢂎", "𢍁", "𩧨", "𭘋", "𭘌", "峀", "𠔔", "𤤧", "𤰰", "𤱁", "𤱉", "𫆚", "𬏁", "𤱤", "𤽙", "𥑤", "𥥉", "𧙏", "𬔈", "袖", "𤉓", "𤉕", "𦥪", "𧆭", "𬱖", "𧲹", "𧻉", "𢆟", "𤲣", "𫔞", "𢆟", "𩊄", "𬰹", "𠟳", "𤰋", "𤳃", "𪳫", "𪽝", "𫘼", "𬏌", "𮏬", "𡳧", "𤳐", "𩿬", "𬏕", "𤳨", "𫠘", "𤳷", "𤳸", "𧈕"});
        addDatum("余", false, new String[]{"溆", "漵", "俆", "叙", "徐", "𡌆", "𡌘", "𡝐", "𡨀", "𡷣", "𡸂", "𢚒", "𪝃", "𫶨", "𬳿", "敍", "敘", "斜", "𢧅", "𣁏", "𣇞", "𣥳", "𤙛", "𦛝", "𭴯", "𤫿", "𤬀", "𤶠", "𥚤", "𥥸", "𫛬", "䍱", "𥺌", "𬡛", "𠎳", "𠕨", "𧧶", "𨌎", "𫀟", "𠄜", "𨴩", "𫒟", "𭫧", "𭭳", "𮀉", "𠐸", "𪊸", "𪑏", "𬹡", "𠑝", "𭣒", "叙", "俆", "溆", "溆"});
        addDatum("羊", false, new String[]{"羡", "𦍌", "详", "𠙌", "𦍏", "𦍐", "𨛁", "𫨇", "𭂎", "𭅒", "㟄", "庠", "𠲘", "𡱝", "𢏙", "𦍒", "𦍔", "𦍕", "𨒫", "𪢪", "𪭰", "𫰧", "𫳅", "𮊣", "𮊤", "𢼝", "𣁵", "𦍗", "𦍘", "𦍙", "𦍜", "𦍞", "𦍠", "𦍢", "𦭵", "𪯷", "𬙭", "𬙮", "𬙯", "𭭋", "祥", "羞", "𥒞", "𥥵", "𦍧", "𦍨", "𦍩", "𦍬", "𦍱", "𦍲", "𦍴", "𫅐", "𫅑", "𫅒", "𬒌", "𬡘", "𭽗", "𮃁", "𮊥", "絴", "翔", "𥬴", "𦍹", "𦍽", "𦎀", "𫅓", "𫅔", "𫅧", "𬙱", "𬙲", "𬙳", "觧", "詳", "𦎉", "𦎊", "𦎋", "𦎑", "𦎒", "𦎓", "𦎔", "𨀘", "𨋽", "𫅕", "𮊩", "鲜", "𨦡", "𬙶", "𮊪", "𮊬", "𮊭", "𦎣", "𦎦", "𦎨", "𦎩", "𦎪", "𦎫", "𦎮", "𩊑", "𫅗", "𫙊", "𬙷", "𮊯", "𦎯", "𦎲", "𩣆", "𩰱", "𫅙", "𬙹", "𬙻", "𮊱", "𮊲", "鮮", "𦎷", "𦎼", "𦎾", "𦏃", "𫅛", "𦏈", "𦏔", "𧒃", "𮊳", "𦏖", "𪔙", "𪢟", "𮊴", "𦏜", "𦏤", "𦏦", "𦏫", "𦏭"});
        addDatum("倉", false, new String[]{"𠥐", "𨜾", "嗆", "搶", "𠞴", "𪤇", "𪦔", "戧", "槍", "熗", "牄", "瑲", "𠟐", "𣯙", "𤚬", "𦞛", "𪰻", "𫀞", "𠏓", "𠏧", "𤾙", "𥎄", "𥏲", "𬔎", "𬡧", "篬", "𥻲", "𦃹", "𬚤", "謒", "蹌", "𧽜", "鎗", "𨶆", "𩀞", "𩝞", "𠑐", "𩮩", "𪙎"});
        addDatum("襄", false, new String[]{"勷", "𨟚", "𨽢", "忀", "骧", "𢐿", "𫗵", "𬙋", "欀", "瓖", "𣀮", "𣤸", "𣩽", "𣰶", "𪱒", "𭤑", "镶", "𤬞", "𤰂", "𥀶", "𥗝", "𧟄", "纕", "𥽬", "𨳃", "鑲", "𩆶", "饟", "𬰰", "驤", "𪊊", "𪓃", "𡗑"});
        addDatum("叟", false, new String[]{"𫍲", "𠪇", "𠭦", "𩨅", "𡻁", "𩨄", "𭎾", "𣯜", "𤔣", "𫌆", "𭵕", "𥕋", "𥰞", "𦃈", "謏", "𧳶", "𧽏", "𫠑", "𩌅", "𩴍", "䱸", "𦣉"});

        //未補全
        addDatum("山", false, new String[]{"仙", "氙", "籼"});
        addDatum("也", false, new String[]{"毑", "灺"});
        addDatum("昜", false, new String[]{"餳"});
        addDatum("芻", false, new String[]{"騶", "趨"});
        addDatum("生", false, new String[]{"性", "姓", "旌"});

        addSingleDatum("需");
        addSingleDatum("稷");
        addSingleDatum("卌");
        addSingleDatum("洊");
        addSingleDatum("尖");
        addSingleDatum("牮");
        addSingleDatum("燹");
        addSingleDatum("鱻");
        addSingleDatum("匠");
        addSingleDatum("戕");
        addSingleDatum("斨");
        addSingleDatum("襄");
        addSingleDatum("鯗");
        addSingleDatum("小");
        addSingleDatum("邪");
        addSingleDatum("些");
        addSingleDatum("卸");
        addSingleDatum("卨");
        addSingleDatum("信");
        addSingleDatum("晶");
        addSingleDatum("酒");
        addSingleDatum("戌");
        addSingleDatum("踅");
        addSingleDatum("卹");

        addSingleDatum("虹");
        addSingleDatum("勦");
        addSingleDatum("椒");
        addSingleDatum("筱");
        addSingleDatum("翛");
        addSingleDatum("竊");
        addSingleDatum("擤");
        addSingleDatum("隰");
        addSingleDatum("褻");
        addSingleDatum("襲");
        addSingleDatum("祆");

        addHalfSPDatum("旬", true, new String[]{"詢", "峋", "恂", "洵", "郇", "殉", "荀", "狥", "徇", "栒"});
        addHalfSPDatum("覃", false, new String[]{"蕈"});
        addHalfSPDatum("雋", true, new String[]{"鐫", "儁", "寯"});
        addHalfSPDatum("糸", false, new String[]{"緒", "絮", "續", "細", "纚", "繻", "絕", "遜"});
        addHalfSPDatum("宣", true, new String[]{"瑄", "揎", "渲"});
        addHalfSPDatum("川", false, new String[]{"紃", "巡"});
        addHalfSPDatum("聿", false, new String[]{"津"});
        addHalfSPDatum("契", false, new String[]{"褉", "揳", "楔"});
        addHalfSPDatum("世", false, new String[]{"紲", "緤", "渫"});
        addHalfSPDatum("僉", true, new String[]{"簽"});
        addHalfSPDatum("爾", false, new String[]{"璽", "獮"});

        //建為團音，顯為團音，鍥為團音，葉紲為團音

        /*
            脊齊即疾祭寂集稷咠七切妻妾戚桼西析徙息舄悉犀枲先習席㬎前戔薦韱千䙴僉青鬵尋泉羨將象焦秋肖喿笑且晉契盡秦心辛卂井省星就酋囚羞脩修秀取胥須序需宿全爵雪巽
            昔耤夋濬旋璿循㵌（亲親新薪媇）囟（䛜㭡）𠬶
            襲璽卌洊尖牮燹暹祆鱻匠戕斨相襄鯗小邪些卸卨親信旌晶酒戌罝薛踅
            責亦四思易朁斬延舌散倉嗇羊肅叟疌（隹雀巀進）曳枼世射也聿爭由（余敘叙俆溆溆）孫山䙴（遷褼蹮韆躚僊）
            虛旬（絢團）血（血侐洫，卹）覃（鐔團蕈尖）雋（觹為團）糸(系為團）宣（煊喧萱楦，宣瑄揎渲）川（訓馴，紃巡）

            來源：
            http://www.zhonghuayinyun.com/ziliao/9.html
         */

        /*
        包含尖音聲旁，但未知是否存在尖團音的字：
        𡲺𢊌𢱣𣖷𣦒𦵾𥕂𦡠𩴎𩮦𩺀𮭉𪗅𡣙𡽉𪗆𪤪𬪜𣋠𪗇𪗈𬀛𬩣𮊞𥐌𥖭𧞓𪗉𪗊𬹲𧓉𪗋𪗌𧾙𨣧𪗍𪊆𪗏𧖊節䳭㑡𪠂𠨞𡖖𡷦𡸎𪪗𭅼𣌸𪺜𠨠𣹜𣩃𪡰𭅽𮔕𥠈𣁚莭𨂢𪃹𠹋𢞱𨕾𤌿𤖏𦶱𧎿𧪠𧽑𮜆𨪏𠭫𨝋𨝠𡻰𭏥𮉯𣘤𪹥䄞𥉻𬖴𧫕𨄊𨢵𨶫𬶭𮢻𮂤𬿟𢠭𫴇𠍱𡙸𢵸𦈜𮥢㱷𣛜𦺴𪹯𪼛𭼫𫋝𮝨𫕱𭬲𮤣𨤹𫘂䮶𪆐𮬏𮦂𩁱𠦫𠶻𡎎𢜱𭍪𥚶𭦱𭵓𥠋𧎎𫃇𧤏𡁢𭋷𩹫𪔪𢍺切𭃃𠮟𭗺𣎽𥤥𦉱𬻎𬂥𨳍𨾅𤶮𩫷𬙞𬴽𩵐𩾔𩾙𮅗𠯦𢗠𢗧𢪃𭎄𮤺𣐆𤆻𬍔𥾛𦕀𫊧𮅀𨥓𨥔𩚦𠉯𨹷𪥼𫅆𬐢𠬎𫋂𫌿𨧬𨿩𩸸𪗍𫍭𡞘𢜡𫲨𣮍𤗈𮌟𥇒𥏡𥟣𧚪𮀨𦁉𧌃𮋵𧩕𧱙𧳛𨨧𥪵𪑗𠗼𡻕㞝𡠽𡻷𤠽𦈚𬴈𤨟𦟠𦸗𥉷𬭭䗩𥼀𦄉𦪊𧐶𫖹𧫳𮙖𩥼𪔯𥀻𬤘𭂜𠻟㯃𦸓𧜝䜉𥣥𣠬𩺲𪄭𧟢𨚹𪠧㛉䧈𡧳𡶼𢬣𤞏𬘟𠒓𤈇𤥒𥙘𦚵𬡸𤶈𤿢𧟪𧟫𬭄䇴𦕩𧟭𬠂𧧍𨠴𬡹𮗆𫘊𪀹𪎢𫙘𧠁𠵍㱤𣨗𪻩𮞝𥇦𥓊𥮥𥺚𩗱𪁻𢇌𢊚𢒩𢳜𫄳𣘩𣯪𥛨𥊂𫆎𩌦𨻁㴧𠺒𬳋𦞜𪬤𫺱𫺽𠒸𥰝𦧯𦧰𧪩𨃡䭒𩔨𢥔𪃼𪄛𢥷𣚔𤺎𩍆𠞹㗭𡡁𢴑𭔎𤎕𦸝𬛐𦄵𨄠𨎒𢥒𬋚𠌬𡼧𥛹𦼗𪼟𤺳𧑷𨬯𣔗𦈒𭱠𢻙𣕘𣗺𣗻𣙂𦂅𦥅𨐠𠢺𣜨𨽿𣝜𦥐𣞟𣟼𣟽𣠎𣠏𠀡𠈣𠜎𢈇𢏡𢓠𢙝𤞓𫩱𬳽㰫㱡𠒑𠒒𣭟𣭡𥙝𦭶𠒛𥏋𥏌𥑻𫪕𭽧䊁𠒣𠸛𠸜𡖬𢔬𦀈𭦞𧠺𧱀𬇶𨴐𨾷𩇜𩛔𫤠𭀲𭀳𠒷𩒙𪞄𬚬𩣂𭀵𠓀𩶤𪀷𫤢𭀷𭀺𨻸𨻿𡏽𢄭𪦞𣄹𣤊𣯥𣯮𤗨𤛊𦸚𮊙𥱵𦒆𦒉𦗗𦧱𧐔𧢇𨄌𨫧𩀦𮤡𩘴𩁙𪄶𠻊𭏖𫟊𥔷𥱊𫏛𬋗𢅺𠠁𡀾𢷑㬤𣩯𤐴𦡹𦿌𤻗𥌁䏉𦆴𤄥𧹽𨆰𨏌𩏰㡐𠷁𡍽𢃬𣹅𩨊𪥗𭚿㮍㷙𠞽𤋎𫆨𧛯𦂒𦑦𬠝𧪈𩋳𠠩𫑠𠵖𡍌𡸚𢈽𢯆𣂧𣮏𤖆𪸶𢧗𤷃𥟥𦋈𠽈𦈻𦎗𧗸𮋇𠒲𧣴𧮺𧶤𨵊𩋋𩤊𪏊𬷟𪘪𧂑𥤆𧟆𦇩𧲛𨰂𨷳𫦟㺤𡄑𡾺𢖝𣰷𣱰𤒯𧃖䆎𤼋𥍀䊱䘋𨇦𨏪𩆷𩟶𩉔𩰁𪖎𠘴𠚲𢌙𬼈𠦅𠦋𭛜𢨮𣅌𤣳𬆼䀒秊𠦞𢆍𣥥𧘜𬑻𭾜䊹𦥛𧗤𨹱𪜍𫇚𫧢𭅡𧮮𧺛𧿐𠦳𬔌𩡴𩵞𩾭𠃇𦼌𭐰䙴𨝍𢕖𢳍𣻝𡼟𣘝𦸊𮂗𥱺𦒘𫎾𩌕𩌷𪄷𡑯𡽗𢅐𨗦𪜇𭍴㷿殮𠐖𢨔𣄝𣜟𣫍𥜋𭭶㿌𥣂𭺷𥽋𦗹𦗼𬜐𧸘𧾏𨆘𮜼𩅼𩟅𭕻䩎𩏩𪇇𭀕𪒫𭯆𠑲䶨晴𠝜𡸺𢃢𢉑𨓽𩇕𫕸𬘬𬮬𭓉𭛯𣮛𤦭𩇖𩇗𭴼靖𤲟𧚫𩇘𩇙𩇚𩇛𫕹𫕺𬰗𬰘𮃇𮄄𮧃𦑊𦑖𩇜請𤎓𫏏䨝𨿬𩜎𩓨𩗼𩇠𫘋𬺚𩇡𪂴𫕼𩇢𩇣𫸎𩇤𩇥𠎅𠟢𨼔𡑎𡼢𢒫𢿼𣎟𤛧𦠅𥖇𥢛𥳍𦅀𧫿𪿃𪵿𠗯𨜩𡎏𡺙𢝓𣸕𪡠𬯏𭒉𣹻𮞰𣻮𤭯𤾌𥠘𬎺𬭣𧍭𫇋𤀁𧪒𧼷𨡹𭚛𩘘𩩺𬉖𥣤𬉨𬉯𬉱𭳾𠿢𦆀𠅵𫦔𪤖𫳻𭊟𭒝𭲎𣩗𤍵𤨿𤖛𤴠𫌏䊢𧽩𨄚𩝫𬦞𮠿𨫥𩝴𩱑䵼𪙝𢄵𢇐𢐣𢠽𤡸𨖶𪮱𫮧𤩪𦺨𬂏𭩈𭶆𮂚𬙧𮃯𫂤𧬛𫏡𬥌𩞧𬥆𬶲𢒶𩕓𧲜𨝱𨿈𢄺𨖵𨸋𨿞𭔓㲬𣤚𥛲𭧭䆶𧝈𨱓𪽢𥼚𦅃𦗠𦣳𨶲𣟼𩏢𩴧𪆄𠩾𨺹𡟊𡥻𡺘𢃸𫐵𬘴𭖽𭛻䐐𤋦𤧐𤧦𥔍𮃚𮖝䋺𦂎𧎐𫆉𮃢𧡣𧤙𧷂𨍊𨡲𪝲䨂𧇸𩄍𩝋𩘌𬳠𮩦𩹤𪃩𪍗䵸𦚍𨛍𡌔𡜽𡯩𢈭𢓮𤞚㲖㲵𢼼𢽐𣆺𣭱𤙜𥙬𤫾𤿨𥹶𦐺𦓴𧣪𧳍𧶈𨡀𨲆𬹈𩛱𬺆𩠦𩡈𩩓𬳘𮆂𪁎𪌯𮝥䨭𪑊𪘞𡮜𢞖𢲑𫹠𣉧𬕓𭡻𧜕𧏣𮆂𫂪𫛎𫨶𢂈𢒉𬲭𭒽𭖍㸖𢨷𤇅𤇙𤔈𤕲𥘲𭁎𭭞𭷚祖𤱌𤿚𥥐𥩢𦊕𦊨𦊩𫸴𬬺𮀀祖𡲂𬅿𡎬𡲤𧠢𧣞𪧠𫿇𭵞䪶𧇇𧇈𩗃𩲲𬌒𭶴𮧊𬁫𧇣𪐵𧇿𮮭𪗱𪽤𡦌𡺽𪬕𦵻𧎽𨍬𨫌𨜒𨜣𭆌𢝛𣸲𭛸𤋸𤧃𦝜𪰳𬢐𦩣𮅳𧩶𧼪𨂰𩴅𩮁𪃈𪟖𢣺𪮺𣃏𥵧𩟝𬬗𥃞𡏑𡻈𫮔𤚩𪜞𫀜𥉜𥱧𬛌𧤛𧽕𨪦𩌘𩘢𩥚𪄈𪒆𬨖𠉄㢹㳯𢓫𣐽𨐍𨐎𬯁𭍤𭝅𭡄㲔𣇛𣓀𤈼𤙡𦛛𨐏𨐑𬍧𬨘𤽮𥏔𥞽𨐒𨐓𪿢𫐚𬨗𬨙𥭴𦀓𦐹𧗶𨐔𨐕𨐖𨐗𫋁𫐛𮇞辞𦑒𧱏𨁅𨌍𨐘𨐙𨐚𨐛𬪬𤨘𨐜𨐝𨐞𨴲𮝼𨐠𨐡𨐣𨐤𨐥𨐦𮧝𮨬𥋑𨐩𨐪𨐮𩷔𮝽𨐶𨐷𨐸𨐺𫐝𫓅𨐿𬨛㚨𤜢𣥇𤣲𤬫𥃴𥝡𠫲𧈲𧮬𧿅𪜖𨾑𣈟𤽰𩑓𩖜𩨖𩡰𩡵𦧾𠀎𠦈𨙷𨸥𭅆𠛝𠯤𢒈𢪝𣲜𪪁𬜣𭃎𣂗𣏨𣥞𣥟𪰉𪱶𫡳𬼾𥐹𥝷𬑽𭾞𭾠𡖚𥬆𦧏𬆓𬙍𬟷𮈃𠄺𠭘𫎁𬪦𮗻𣸕𨥙𨳩𤌌𩾺𣊼𨐨𪔏𬀶𬾰𡟙𬴄𭈻𭡦𠬋𣨾𣮶𪻹𭦷𮂇䃏𥠀𧛟䗌𦎬𦖤𦩠𪞃𣋀𧡶𪱊𫎻𬁖𭧰𭧻𮛲𨩛𩄆𬁚𬉚𬶢𭧼𣋮𪱎𭨅𮩥𩤵𣌌𫠛𣌜𤎼𤏅𦠢𪼝𥳛𧑙𮕀𧫾𫎢𮚦𩀻𪆩𠄁𨜟𨺧𡞜𡯾𡲚𡺚𢉷𢍜𪡧𬘶㻥𣣫𣮩𤋃𦝱𦳷𬨎𤸈𦖣𦩲𮉶𧤕𧳫𨡴𨢅𨢈𨩊𫜟𩔕𮡂𩮈𮡃𨣡𪃬𪍑𪓰𪓵𠧚𢘄𨒊𭛢𠉁𣐮𣧝𣭃𪸜𥁕𬑋𧣕𨥱𮨃𤨩𦟤𥀞𦪋𬖱䡭𩘭𪅠𫅡𬚂𭢎䐰𤛛𥉈𥠿䗛𦃬𮆀𪅭𡟞𢟅𣺫𫝽𭉫㹋𡪇𣘀𥈌𦤜𥱤𬗲𬠡𩝧𫙯𠃯𠉑𨹳㛢𢓵𢭆𣵛𪣜𫵿𮂼𣒴𣮁𤥹𥙾𬊔𤯪𥏗𧚘𮀞𨴷𥢁𮪆𪁮𥣧𥤃𠉧𨛿𡱾𡸘𡸨𢃣𢈾𢛏𢮝𣷗𨓭𪪿𭰮𮉪㻓𤔛𤕖𤚉𤦟𦕪𦝒𪞔𪺐𭴻最𤭡𥦡𥪏𧚥𧚿𦁫𧌗𫃂𫩉𭒒𣍇𥧖𦖰𧩞𧱛𫮣𬥁𮗕𠮊𠮋𪠱𦗘𩋄𮪊𪋄𮕉𪘸𭂘𡹲𤟠𩠋𥚩𬨏𤸀䈝𦠷𧶳𨍐𩝔𩾊𮢦𪙀𠾫𢄼𢊼𣛪𩒹䇓𩓾𥳗𦄼𦅓𮖶𨅑𢒷𨬗𩅺𩔾𣌌𪆦𨹘𡜾𢭸𦯅𫸉㓌𠛮𠤹𨛈𨹑𠱴𡋄𢂘𩧴𬘥㻇𠓰𪞇𪰡𮁵𦓰𧊲𫆂𫤪𠓴𧻤𠓹𠓻𪼈𫗐𫣝𫗽𠓾𣁦𦦮𫤍𬣎𨇎𠘣𫤼𢥚𫸤𦣅𭚞𥷮𮉜𮍟𨇺𨰜𬺖𬋺𫑲𪚅𠞯𪞵𠽌𡐅𡠭𢳬𫕣𬝹𤍱𩃏𬎅𫃽𫟀𩅷𫂪𨯎𤓨𬤥𡢀𡮭𢵬𦈝𤩄𦠆𦺈𦌔𡮸𧾌𦧸𪟼𩪞𩦖𩻝𤁏𨆮𠗕𠣟𨛐𭐤𡱥𢈡𢏤𢓭𭖨𭘁㻐𠅣𡕧𡕬𥚂𭦕𭯚𤽭𥍬𧚉𭽫𠨢𠬌𥭟𦀷𦑁𦑂𦫝𭐩𮋰𮔖䝜𠬍𨌘𭐪𨿓𩈥𩊻𩓀𩰺𪊴𮭬𮇾𪕞𪘑𢄲𢕐𢳄𩠍𣎓𭥄䃠𥪱𧜽𧐗𩘶𪍧𣛝𧝩𦅑\uD842\uDF36𠜘𡨞𢔀𢬶𭆰𢽖𣆲𦯈𭴵𭷆𭹔𥆷𥍯𮃆𮄀䘲𥺑䜷𨡉𮛟𩒸䯹𪖧𨽨𣠟𠍊𢳔𪩻𫫠𫺿𡪴𣩐𤛝𦟱𥀝𥕯𫔊𥼍𧐴𨢲𨣡𩐼𩘰𩥿𨜜𡞞𡨽𢜫𭖶𣦉𦳗𪻻𫆦𪾱𫵆𦔄𧍖𨲓𫍂𨩠𨵥𩩭𪱐𬥇𠟯𫥛𬤨𤢖𪤢𢻥𢿾𣀉𣋝𣜣𣰕𦾈𩙰䆆𡂟𥖨𥼾𦏛𦗵𧒮𧴜𩟎𫚫𫧭𩙈𩯟𮪚𪍻𪍽𥽹𠎭𠪣𠾎𢄻𢊰𤩀𦠐𦺻𪯗䃟𥂪𥋌𧝠𫔌𧽾𨅖𮣂𪯝𠎸𠟩𠢳𡀁𡫆𭢲𢿿𤗼𤛷𥜎𬎓𧒗𬬋𩍙𩏫𩕡𩼒𠏐𡼣𪬵𫱷𦘤𦪓𧑛𧽷𨅋𮋕𬣉𩘹𮩰𪆭𨺇𡹈𢈻𢏵𢜀𣶏𤟃𨓰𣄂𣓉𣮌𤙶𬍫𤲣𥓐𧚨䑖𦑈𦩌𦑯𩃖𦦘𩗳𨤴𪖮𠗨𠝝𡺑𢜨𣓪𫄬𭪭𭸗𣈽𣖦𤭴𥏭𥠓𬃯葉𥻈𦉃𫖷𭫮𮋶𧽅𨍕𨤘𫌣𨵳𩄓𩐱𩔑𩘏𩳶𬙾𪃸𪍐𧃹𪑧𮆩𠲜𨛰𬋨𡸵𢏰𢛵𫐭𡴣𦱊𪟐𪰭𪸾𪺓𠬉𠎈𥺲𦓺𨌢𨲌𪬭𪺗𤔷𦽰𩓞𩗲𨘱𪢛𫣺𧬦䙴𨝍𢕖𢳍𣻝𡼟𣘝𦸊𮂗𥱺𦒘𫎾𩌕𪄷𨖊𭍬𣤈𤖓𤗮𦟜𤳎𤹠𥎍𥡯𧶷𭽴𮂒𥼃𦎸𦣱𧐐𨢦𨲪䥊𩄾𫗙𮥜𩌪𩔳𫘁𮧐𪄸𪒑𠲔𢙕𫔱𫼬𢼜𤥂𦮰𫿳𬀳𬁢𭥼𭴢𣷖𧙡𬒵𠅯𥿹𧊤𬖛𡙩𧧩𨀶𫒚𩎭𩷉𪁂𪊳𢏎𢪾𣳉𪯣𮕳𥹊𥿖𧣛𫪸䦉𠅤𠖓𢛥𨜐𨺯𫍰𤟧𪮏𭓑𢞨𢞰𤋘𢠞𤸛𦋮𫀼𥯨𥻏𦖷𦖻𦩭𧍤𧗂𬜉䞏𨡾𢣢𦻇𪃄𭟜𪕳㛫𠴭𡱿𡸑𢃡𢒗𤟍𫶁𬀺𬪉𬯆𭕏㻛𣂨𣓾𣨟𣱢𫀒𫾻𬊙𬊛𬻸𭶱𮌝𢾙𣈱𥍴𥓘𥚯𥟘𥪔𫨭𬙢𭽛䓪𠖞𣉝𣉠𣉷𥮬𦓻𣋇𧩎𨲎𪱁𬁏𭧚𡀻𣊷𧼮𩃮𩛿𩋌𩗺𭧺𥂺𪎥𪎧𦦸𪕩𣌒𨼐𡡖𦻳𪯘𥎑𧝆𣩳糣𨅔𩀿𩅨鐕𩻛𪅽𪖼𠌲𭄇𠼃𠼗𡐛𢄤𣊙𤍖𬆉𥕌𥪭𦗚𦗝𧐮𮅼𧴃𧽯𬧋𩀧𩞏𩈻𩴕𠈰㝚𢚀𫄧𫷳𭖮𮥋𣆴𣇇𭦋𤥻𮁺𮃾𮣴𦕣𦧝𦋪𨁆𩃀𦧆𫇔𡇜𡯢𦧇𭓯𮍴𮍵𢼤𣁳𣢯𣭪𤈏𦧈𦧉𦧊𦧋𦧌𦧍𦧎𦧏𦧐𭥹𤫵𤭇𥚇𦧑𦧒𦧓𦧔𬜅𬜆𮍶𮍷𦧖𦧗𦧘𦧙𦧚𦧛𦧜𦨯𬚸𬛥𬱠𦧝𦧞𧵳𨈸𫇖𬜇𮝐辞𦧟𦧠𦧡𦧢𦧣𦧤𦧥𦧦𫕛𫫞𬜈𬺄𣽰𦧧𦧩𦧪𦧫𦧬𩈙𬜉𬜊𬜌𬜍𮍺𮍻𮍼𮍽𮍾𮧺𦧭𦧮𦧯𦧰𫇗𦧱𦧲𧱳𪌩𪎾𫬎𬵏𦧴𬜎𦧷𫇘𬜏𬜐𪗽𦧺𦧻𦧼𮎀𦧽𠃲䧱𠻘𡦓𣼎𭗋𢧵𤍳𪾻𬑥𮀿𠓃𫋗𧽟𨄤𨫠𪅓𮭕𪖀𬿫𭗝𭞷𭢜𣛎𦻗𬔀𥳟𧾄𠈐𡜄𢂝𢘽𨒧𫲥㡼𤤺𦛈𤥟𤵺𧙟𭾫䒶𡲝𥹞𦐪𦓕𧊣𠻇𡲭𧻭𨋯𨱽𫒗𤲼𩊒𩎥𧽇𧽈𩬲𪀕𠗨𠝝𡺑𢜨𣓪𫄬𭪭𭸗𣈽𣖦𤭴𥏭𥠓𬃯葉𥻈𦉃𫖷𭫮𮋶𧽅𨍕𨤘𫌣𨵳𩄓𩐱𩔑𩘏𩳶𬙾𪃸𪍐𧃹𪑧𮆩𡛶𢇸𪣅𢺿𤤙𦭓𬆑𭁫𠁀𥅋𫢫𬔛𬙚𭁯𣫸𥹑𦐕𦐞𧉺𮎉𮓽𧺿𬡽𩊈𢲌𤚑𤠭𫷺𥛖𭵪𡭉𧛼𪧻𪿎𬙥𥱈𧎭𬮏𩘧𬳢𠨱𫍙𬺼𬼜𡧀𢇚𤜣𪨥𭍽𢻫𢻱𤕮𤖪𦬎𥃸𥐨𭕗𡖐𦍔𦏸𦐁𦧇𫂴𬼨𬾍𭇠𮋭𮌊𧠉𧺏𧿇𨤤𬼭𬾡𭆰𭕟𮜮𩚉𬮆𬼩𬼮𬼰𭅤𭔳𭰿𥝀𬽓𭘬𩵔𭻠𮏡𭞱𮟉𭔞𮮶𭢽𭀍𭀎𮌁𠜈𦘓𬎾𮌂律𡷏𢘶𢫫𤝽𦘔𣑵𤈠𦛌𥞰𦘖𦘗𧙻𥹧𦨱𧊐𧧪𧱇𨀞𫆔𬚫𦘞𦘟𫆕𫽹𦘠𮌅𩬶𬚭𦘥𦘦𪀴𪁀𫙟𠲜𨛰𬋨𡸵𢏰𢛵𫐭𡴣𦱊𪟐𪰭𪸾𪺓𠬉𠎈𥺲𦓺𨌢𨲌𪬭𪺗𤔷𦽰𩓞𩗲𨘱𪢛𫣺𧬦㐕𠃦𤰔㕀𠔍𫔼𠰬𠱋𡊡𡘊𡛽𡱋𢂎𢍁𩧨𭘋𭘌峀𠔔𤤧𤰰𤱁𤱉𫆚𬏁𤱤𤽙𥑤𥥉𧙏𬔈𤉓𤉕𦥪𧆭𬱖𧲹𧻉𢆟𤲣𫔞𢆟𩊄𬰹𠟳𤰋𤳃𪳫𪽝𫘼𬏌𮏬𡳧𤳐𩿬𬏕𤳨𫠘𤳷𤳸𧈕𡌆𡌘𡝐𡨀𡷣𡸂𢚒𪝃𫶨𬳿𢧅𣁏𣇞𣥳𤙛𦛝𭴯𤫿𤬀𤶠𥚤𥥸𫛬䋡𥺌𬡛䞮𠎳𠕨𧧶𨌎𫀟𠄜𨴩𫒟𭫧𭭳𮀉𠐸𪊸𪑏𬹡𠑝𭣒𡴭𡴮𡴯𠘳𡴰𡴱𡴲𡴳𡴴𡴵𡴶𡴷𡴸𡴹𡴺𡴻𡴼𡴽𢌚𫵱𫵲𫵳𫵴𭂈㞮㢫𠮿𡆯𡚴𡴾𡴿𡵀𡵁𡵃𡵅𡵆𡵇𡵈𡵉𡵊𡵋𡵌𡵍𡵎𡵏𡵑𡵒𢇢𢌲𢩳𤜬𪨢𪨣𪨤𪨥𫝳𫵵𬜡𭓞𭖁𭖂𭖃𭖄𭗼㞱㞵㰞𡵓𡵔𡵕𡵖𡵘𡵙𡵚𡵛𡵜𡵝𡵞𡵟𡵠𡵡𡵢𡵣𡵥𡵦𡵧𡵨𡵩𡵪𡵫𡵬𡵭𡵮𡵯𡵰𡵱𡵲𡵳𡵴𡵵𡵶𡵷𡵸𡵹𡵺𡵻𡵼𡵽𡵾𡵿𡶀𡶁𣧈𤕏𤣶𦘹𪨦𪨧𪨨𫐅𫵶𫵷𬍑𭖆𭖇𭖉𭖊𭖎𭖑𠰛𡶃𡶄𡶅𡶆𡶇𡶈𡶉𡶊𡶋𡶌𡶎𡶏𡶐𡶑𡶒𡶔𡶕𡶖𡶗𡶘𡶙𡶚𡶛𡶜𡶝𡶞𡶟𡶡𡶢𡶤𡶥𡶦𡶧𡶨𡶩𡶪𥐢𦒴𪨩𪨪𪨫𪨬𪨭𪨮𫵸𫵹𬑭𭇝𭖋𭖌𭖍𭖐𭖓𭖔𭺱峀𡶫𡶬𡶭𡶯𡶰𡶱𡶲𡶴𡶵𡶶𡶷𡶺𡶻𡶼𡶽𡶾𡷀𡷁𡷂𡷃𡷅𡷆𡷇𡷈𡷋𡷌𡷍𡷎𡷏𡷐𡷑𡷒𡷓𡷔𦏿𦔺𦣟𧗣𪨯𪨰𪨱𪨲𪨳𪨴𫂳𫝴𫵺𫵻𬟴𭖕𭖖𭖘𭖙𭖚𭖝𭖞𮈁岍㟒㟕豈𡷕𡷖𡷗𡷘𡷙𡷛𡷝𡷞𡷟𡷠𡷡𡷢𡷣𡷤𡷥𡷦𡷧𡷨𡷫𡷭𡷯𡷰𡷱𡷲𡷴𡷵𡷷𡷸𡷹𡷺𡷻𡷽𡷾𡷿𡸀𡸂𡸃𡸄𡸅𡸇𡸈𡸉𡸊𡸌𡸎𡸏𪨵𪨷𪨸𪨹𪨺𫝵𫵼𫵽𫵾𫵿𫶀𫶃𭖟𭖠𭖡𭖢𭖣𭖤𭖥𭖦𭖧𭖨𭖮𡷤𡷦㟡㟣㟥崙𡸑𡸒𡸕𡸖𡸗𡸘𡸙𡸚𡸛𡸜𡸝𡸞𡸟𡸠𡸢𡸣𡸤𡸥𡸦𡸨𡸩𡸪𡸫𡸬𡸮𡸯𡸰𡸲𡸳𡸴𡸵𡸶𡸷𡸹𡸺𡸻𡸼𡸽𡸾𡹁𡹃𡹄𡹅𡹇𡹈𡹉𡹋𡹌𡹎𡹐𡹓𡹔𡹕𡹖𡹗𡹘𡹙𡹚𡹛𡹜𡹝𡹞𡹟𡹠𡹡𡹢𡹣𡹤𡹥𡹦𡹧𡹩𤈹𨥉𪨻𪨼𪨾𪩁𫶁𫶂𫶄𫶅𭖩𭖪𭖫𭖬𭖭𭖰𭖱嵐﨑𡹪𡹫𡹬𡹭𡹮𡹯𡹰𡹱𡹲𡹳𡹴𡹵𡹶𡹷𡹸𡹹𡹺𡹾𡺀𡺁𡺂𡺃𡺄𡺅𡺆𡺇𡺈𡺉𡺋𡺌𡺍𡺏𡺐𡺑𡺓𡺔𡺕𡺖𡺗𡺘𡺙𡺚𡺜𡺝𡺞𡺟𡺠𡺡𡺢𡺣𡺤𡺥𡺦𡺧𡺨𡺩𦰷𩖞𩲀𩲈𪩂𪩃𪩄𪩅𪩆𪩇𫶆𫶇𫶈𫶉𭖳𭖴𭖵𭖶𭖷𭖸𭖹𭖺𭖻𭖽𭖾𭖿嵃㟸𡺪𡺫𡺬𡺭𡺯𡺰𡺱𡺲𡺴𡺵𡺶𡺷𡺸𡺹𡺺𡺼𡺽𡺾𡺿𡻀𡻁𡻂𡻃𡻄𡻅𡻈𡻉𡻊𡻋𡻌𡻐𡻑𡻒𡻓𡻔𡻕𡻖𡻗𩫺𪩉𪩊𪩋𫶊𫶌𫶍𫶎𫶏𫶐𬺘𭗀𭗁𭗃𭗅𭗆𭗈嵮嵫㟾㠁㠃𡻘𡻙𡻚𡻜𡻝𡻞𡻟𡻠𡻡𡻢𡻣𡻤𡻥𡻧𡻨𡻩𡻪𡻬𡻭𡻮𡻯𡻰𡻱𡻳𡻴𡻷𡻸𡻹𡻺𡻻𡻼𡼁𡼂𡼃𡼄𡼅𡼆𡼇𡼈𡼉𦷤𧶑𪩌𪩍𪩎𪩏𪩐𪩑𪩒𫶒𫶓𭗋𭗌
         */
    }

    private static final void addDatum(String shengpang, boolean containItself, String[] contains) {
        data.add(new Shengpang(shengpang, containItself, contains));
    }

    private static final void addHalfSPDatum(String shengpang, boolean containItself, String[] contains) {
        data.add(new Shengpang(shengpang, containItself, contains, true));
    }

    private static final void addSingleDatum(String character) {
        data.add(new Shengpang(character));
    }
}
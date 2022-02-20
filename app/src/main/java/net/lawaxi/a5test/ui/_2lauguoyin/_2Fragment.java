package net.lawaxi.a5test.ui._2lauguoyin;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.spreada.utils.chinese.ZHConverter;
import net.lawaxi.a5test.R;
import net.lawaxi.a5test.ui._2lauguoyin.utils.common;
import java.util.ArrayList;
import java.util.List;

public class _2Fragment extends Fragment {

    public static final String data = "er（兒）zhi1（知枝支肢之芝脂蜘）chi1（癡痴）shi1（詩師獅尸屍施）chi2（池馳遲持<b>治</b>）shi2（時鰣<b>匙</b>）zhi3（止趾址旨指紙只<b>徵</b>）chi3（齒耻恥侈）shi3（使史駛<b>施</b>始屎矢豕）zhi4（治智制製志痣痔誌滯稚稺至致<b>熾</b>置寘）chi4（翅）shi4（事是試弒氏嗜世示市侍恃勢視誓逝士仕似施柿舐䑛）zhi5（直值植殖姪執汁質擲職織<b>蟄</b>秩隻炙）chi5（尺吃喫赤斥飭）shi5（十石拾食失室實寔式濕溼識適釋什飾蝕）ri5（日）zhi（<b>着著</b>）zi1（滋茲資）ci1（<b>雌</b>差疵）si1（絲私撕斯廝思司）ci2（詞慈瓷磁辭祠）zi3（子紫姊）ci3（此<b>疵</b>）si3（死）zi4（字自）ci4（次刺伺賜<b>廁</b>）si4（四寺肆似巳<b>賜</b>俟嗣）zi（子）yi1（<b>她</b>伊衣依醫噫）pi1（披批砒丕）di1（低）ti1（梯）ji1（雞鷄基期箕几飢肌姬機机譏饑稽奇竒）qi1（<b>谿溪崎</b>欺）xi1（嘻犧稀希唏嬉熙）zyi1（劑）cyi1（妻悽淒凄萋棲）syi1（西犀嘶<b>棲</b>）yi2（宜夷姨疑移遺儀怡）pi2（皮疲枇毗琵脾）mi2（迷糜彌）ti2（提<b>隄堤</b>題蹄啼）ni2（泥）li2（梨黎釐麗厘狸貍離璃漓籬）qi2（奇崎騎岐歧旗<b>期</b>棋麒棊碁其祈旂耆）nji2（尼呢倪霓）xi2（<b>兮奚攜</b>）cyi2（齊臍）yi3（椅倚以蟻已矣）bi3（比彼鄙<b>婢</b>）mi3（米）di3（底抵）ti3（體体<b>涕</b>）ni3（你伱）li3（里理裡裏鯉俚李<b>履</b>禮礼）ji3（幾己几<b>紀</b>）qi3（起豈啟啓企杞）nji3（擬）xi3（喜）zyi3（擠）syi3（洗徙璽）yi4（意異義議藝肄誼裔易倚毅）bi4（閉<b>秘</b>避敝弊幣斃蔽臂陛婢）pi4（譬屁）mi4（<b>謎</b>）di4（地弟第帝遞棣）ti4（替嚏剃涕）li4（例利痢荔隸厲勵蠣麗儷吏）ji4（記計寄季既忌繼技妓繫冀<b>騎</b>）qi4（企氣器噐棄契亟）nji4（膩）xi4（戲係系繫）zyi4（際祭劑霽薺濟）cyi4（<b>砌</b>）syi4（細）yi5（一弌乙億憶揖易蜴<b>液</b>益溢疫役拽邑抑亦奕弈逸佚壹弋譯驛腋翼）bi5（筆必壁璧擘辟畢逼碧愎弼<b>鼻</b>）pi5（匹疋辟僻癖劈霹）mi5（密蜜覓覔）di5（的笛敵滴嫡狄滌）ti5（踢剔）li5（力立歷靂曆瀝粒笠栗）ji5（急極及汲岌級吉棘亟激擊給）qi5（乞訖迄吃喫泣）nji5（逆匿溺）xi5（吸隙）zyi5（績積即卽集寂跡迹疾脊瘠緝輯稷嫉籍唧）cyi5（七柒漆戚）syi5（<b>圾</b>席息媳熄惜昔習錫夕膝悉蟋析蜥淅襲）li（哩）nji（呢）wu1（烏嗚污汙）pu1（鋪）fu1（夫膚敷<b>俘孚</b>）du1（都）lu1（嚕）gu1（姑沽菇辜孤箍）ku1（枯）hu1（呼）zhu1（朱珠株誅蛛諸猪豬）chu1（初）shu1（書輸梳蔬疏疎舒樞）zu1（租）cu1（粗麤）su1（蘇酥）wu2（吳吴無蕪吾梧<b>巫</b>毋蜈）pu2（蒲葡菩）mu2（模<b>摹膜</b>）fu2（扶芙夫符浮俘）tu2（圖途塗徒屠）nu2（奴）lu2（盧爐蘆廬鱸顱鑪）hu2（壺乎胡湖糊鬍瑚葫衚蝴餬狐弧<b>瓠</b>）chu2（除廚櫥躇雛鋤）shu2（<b>殊</b>）ru2（如儒孺）wu3（五伍武鵡<b>撫</b>舞午侮）bu3（補）pu3（普譜浦）mu3（母畝姆）fu3（府俯腑腐甫斧撫）du3（堵賭睹覩肚）tu3（土吐）nu3（努）lu3（鹵滷魯櫓虜）gu3（古<b>估</b>鼓賈股）ku3（苦）hu3（虎琥滸）zhu3（主煮）chu3（楚礎處処杵褚）shu3（暑署黍鼠數）ru3（乳汝）zu3（祖阻組）wu4（務霧戊誤悟晤寤<b>汙污</b>惡）bu4（布佈怖步部簿<b>捕哺</b>埠）pu4（鋪舖）mu4（募墓暮慕）fu4（父婦負付副傅富賦赴訃咐附駙<b>腐輔</b>）du4（渡度鍍杜肚妒妬蠹）tu4（吐兔兎）nu4（怒）lu4（路露賂鷺）gu4（故雇僱顧固）ku4（庫褲袴）hu4（互戶滬瓠護）zhu4（住注註柱蛀駐著箸助鑄<b>誅</b>）chu4（處処）shu4（樹恕數豎戍庶墅）cu4（醋<b>措</b>）su4（素溯愬訴）ru4（<b>孺</b>）wu5（屋物勿沃）bu5（不卜）pu5（僕撲瀑）mu5（木目沐牧）fu5（福蝠幅弗佛彿拂髴伏復腹馥覆複服）du5（讀毒獨督篤）tu5（禿凸突）lu5（六綠祿錄陸鹿）gu5（<b>告</b>骨谷穀）ku5（哭酷）hu5（忽惚斛）zhu5（竹竺逐燭<b>粥</b>祝筑築<b>軸</b>屬属囑）chu5（出畜觸齣）shu5（叔熟塾孰述贖縮術束倏蜀屬属）ru5（入肉辱褥）zu5（足卒族）cu5（促）su5（俗宿肃肅速夙粟）yu1（迂）jyu1（居拘駒車<b>俱</b>）qyu1（區驅軀）xyu1（虛吁噓）cyu1（趨蛆）syu1（須鬚需胥）yu2（魚漁于<b>迂</b>盂余隅愚予歟輿譽臾餘愉榆楡虞娛於）lyu2（驢）qyu2（渠佢瞿）syu2（徐）yu3（雨羽與語宇禹麌）lyu3（吕呂侶旅屢縷）jyu3（舉矩）njyu3（女）xyu3（許）cyu3（取娶）yu4（遇寓與御禦預裕<b>愉</b>諭譽豫<b>娛</b>愈隅）lyu4（慮濾）jyu4（具颶懼句據遽巨苣鉅距拒鋸）qyu4（去）zyu4（聚）cyu4（趣）syu4（序敘叙婿緒絮續）yu5（玉欲慾浴育獄尉熨域鬱）lyu5（律率）jyu5（局菊鞠橘劇）qyu5（屈曲麯）xyu5（畜蓄旭）syu5（戌續恤卹）a1（阿啊）ba1（巴<b>杷</b>疤）pa1（趴<b>乓</b>）ma1（媽）ta1（他）la1（拉）ha1（哈<b>呵</b>）zha1（渣）cha1（叉差）sha1（沙砂紗裟）ya1（丫呀鴉）jia1（家佳嘉枷加伽袈）xia1（蝦）wa1（蛙<b>娃</b>哇窪漥媧）gua1（瓜）kua1（誇）hua1（花）zhua1（抓）ba2（<b>杷</b>）pa2（趴扒爬琶）ma2（麻蔴蟆）na2（拿拏）cha2（茶搽查）za2（咱喒偺）ya2（牙芽崖涯衙）qia2（<b>伽</b>）xia2（霞）hua2（華）ba3（把靶）ma3（馬瑪碼螞）da3（打）na3（哪<b>那</b>）ka3（卡）sha3（傻）sa3（洒灑）ya3（雅<b>亞</b>啞）lia3（倆）jia3（假賈）qia3（卡）wa3（瓦）gua3（寡）zhua3（爪）shua3（耍）ba4（爸把<b>靶</b>罷霸壩）pa4（怕）ma4（罵禡）da4（大）na4（那）zha4（乍炸詐榨<b>蔗</b>）cha4（詫岔<b>䛽</b>）ya4（訝迓亞）jia4（嫁架駕價价假）xia4（下夏<b>暇</b>嚇）gua4（挂卦掛褂）kua4（跨）hua4（化話畫）a5（阿）ba5（八叭拔捌）pa5（帕<b>乓</b>）fa5（法伐筏發髪髮罰乏）da5（搭答達）ta5（搭塔搨塌榻踏獺）na5（捺納吶）la5（拉辣剌喇蠟臘腊）zha5（炸扎札閘）cha5（插䛽察擦剎）sha5（煞殺剎柵）za5（紥雜砸）ca5（擦）sa5（煞撒薩颯）ya5（鴨押壓）jia5（夾俠甲）qia5（掐恰）xia5（匣狎俠峽狹<b>洽</b>瞎黠）wa5（挖襪）gua5（括刮聒颳）hua5（滑猾劃<b>豁</b>）shua5（刷）a（阿）ba（吧）ma（嗎麼）la（了啦）o1（哦<b>阿</b>）bo1（波玻播）po1（坡）do1（多）to1（牠拖）go1（哥歌戈）ko1（科苛柯顆窠）ho1（呵）co1（搓）wo1（窩萵）guo1（鍋）suo1（梭蓑）po2（婆鄱）mo2（摩磨麼魔）to2（駝馱陀鴕）no2（娜）lo2（羅鑼蘿）ngo2（俄娥蛾峨哦鵝訛）ho2（何河荷禾和龢）nuo2（挪）luo2（騾螺）bo3（跛播）po3（<b>頗</b>）mo3（<b>麼</b>）ko3（可顆哿）ngo3（我）zo3（左）duo3（朵朶躲）tuo3（妥橢）luo3（<b>卵</b>裸）guo3（果菓裹）huo3（火伙夥）suo3（所鎖瑣）bo4（<b>播</b>簸）po4（<b>頗</b>破）mo4（磨）do4（柁舵）go4（個个箇）ko4（課）ngo4（餓）ho4（賀荷）zo4（做<b>佐</b>）co4（錯）wo4（臥）duo4（惰墮剁跺）tuo4（唾）nuo4（糯）guo4（過）huo4（禍貨）zuo4（坐座）cuo4（挫）o5（惡）bo5（撥薄搏博駁剝脖渤勃餑泊蔔雹瀑）po5（潑）mo5（莫摸漠<b>幕</b>寞膜末抹沒）fo5（縛）do5（度）to5（托託）no5（諾）lo5（樂洛絡烙落駱咯）go5（各咯蛤閣擱割葛鴿）ko5（渴磕壳殼）ngo5（鄂愕齶鱷）ho5（合盒闔盍鶴壑曷喝郝）zho5（著着酌勺斫）cho5（戳）sho5（芍勺杓索）ro5（若弱）zo5（作）co5（錯）so5（索）yo5（約喲唷葯藥龠鑰岳嶽樂躍）lio5（略畧掠）jio5（脚腳覺角）qio5（確卻却）njio5（虐瘧謔）xio5（學）zio5（爵嚼）cio5（雀鵲）sio5（削）wo5（握齷）duo5（奪）tuo5（脫）guo5（國郭）kuo5（闊擴）huo5（或活惑獲霍藿攉<b>畫</b>）zhuo5（捉卓桌棹濁鐲濯琢拙）chuo5（齪）shuo5（說朔率）zuo5（昨鑿）cuo5（撮）jyuo5（攫）zheo1（遮）cheo1（車）sheo1（奢）sheo2（<b>甚什</b>蛇）zheo3（者）cheo3（扯）sheo3（捨）reo3（惹）zheo4（這蔗）sheo4（舍射社赦麝）eo5（厄呃扼）beo5（北白百伯柏<b>迫</b>帛）peo5（拍珀魄迫）meo5（墨默麥脈<b>沒</b>陌）deo5（德得）teo5（特忒忑）leo5（<b>肋</b>勒）geo5（格胳骼隔膈革）keo5（客刻咳克）ngeo5（額）heo5（黑嘿核赫嚇）zheo5（宅窄擇澤炙蟄摘折浙哲摺）cheo5（斥拆撤）sheo5（瑟澀蝨虱什<b>蟀</b>舌設涉攝）reo5（熱）zeo5（則側責嘖賊窄仄昃）ceo5（冊册測惻策）seo5（色澀塞）leo（了）geo（个個）zheo（著着）zhe1（遮）che1（車）she1（奢）die1（爹）zie1（嗟）sie1（些）xyue1（靴）she2（蛇）ye2（爺<b>耶椰揶</b>）qie2（茄）sie2（斜邪）zhe3（者）che3（扯）she3（捨）re3（惹）ye3（也野冶）zie3（姐）cie3（且）sie3（寫）zhe4（這蔗）she4（舍射社赦麝）ye4（夜）zie4（借藉）sie4（謝瀉卸）zhe5（折浙哲摺）che5（撤）she5（舌設涉攝）re5（熱）ye5（葉頁業咽）bie5（別鼈）pie5（撇）mie5（滅）die5（跌迭碟蝶牒疊叠㩹）tie5（鐵鉄貼帖）lie5（列裂烈獵）jie5（結揭竭傑劫刦潔孑莢）qie5（怯契）njie5（捏孽）xie5（歇蝎蠍俠挾叶協脅）zie5（節接捷睫截楫）cie5（切妾竊）sie5（屑洩契）yue5（月曰越閱悅粵）lyue5（劣）jyue5（决決訣掘倔窟厥）qyue5（缺闕）xyue5（血穴）zyue5（絕）syue5（雪薛）lie（咧）ai1（噯哀挨埃唉哎）bai1（擘）dai1（獃呆）tai1（台胎）gai1（該）kai1（開揩）hai1（<b>唉</b>）zhai1（齋）chai1（差釵）shai1（篩）zai1（災栽哉）cai1（猜）sai1（腮顋）jiai1（街皆<b>偕</b>階）wai1（歪）guai1（乖娃）chuai1（揣）shuai1（衰摔）pai2（排牌徘）mai2（埋霾）tai2（台臺擡枱檯抬苔）lai2（來萊）ngai2（<b>呆獃</b>）hai2（孩<b>還</b>）chai2（柴豺儕）cai2（才財材裁纔）yai2（厓）xiai2（鞋諧）huai2（懷槐淮）ai3（矮）bai3（擺）mai3（買）dai3（歹）nai3（乃奶<b>鼐</b>）gai3（改）kai3（楷凱愷慨）hai3（海）shai3（灑洒）zai3（宰<b>囝</b>載）cai3（彩採采䌽）jiai3（解）xiai3（蟹）guai3（拐）chuai3（<b>揣</b>）shuai3（摔甩）ai4（愛<b>藹靄</b>）bai4（拜敗）pai4（派）mai4（賣邁）dai4（代袋貸戴黛帶待殆怠大玳）tai4（太汰泰態）nai4（耐奈）lai4（賴癩）gai4（蓋盖丐概溉）kai4（<b>慨</b>）ngai4（艾礙碍）hai4（害亥駭）zhai4（債寨）shai4（曬晒<b>殺</b>）zai4（在再載）cai4（蔡菜）sai4（塞賽）jiai4（介芥界疥戒械誡屆）xiai4（械）wai4（外）guai4（怪）kuai4（快筷塊）huai4（壞）zhuai4（拽）shuai4（帥率）bei1（杯卑碑悲）pei1（呸肧胚）fei1（飛非扉霏妃）lei2（擂）hei1（嘿）wei1（威畏煨萎<b>蝟</b>）duei1（堆）tuei1（推）guei1（規歸圭閨龜瑰）kuei1（虧盔窺<b>魁奎</b>）huei1（灰恢詼揮煇暉輝徽）zhuei1（追錐）chuei1（吹炊）cuei1（崔催衰）suei1（雖<b>尿</b>）pei2（陪培賠）mei2（眉睂嵋煤媒玫枚梅霉）fei2（肥）vei2（微薇）wei2（為爲偽謂<b>危</b>桅圍韋違幃惟維<b>微薇</b>）luei2（雷）kuei2（葵夔魁）huei2（回囘<b>徊</b>茴）chuei2（槌鎚垂錘）shuei2（誰）suei2（隨隋）mei3（美每）fei3（匪翡吠）vei3（尾）gei3（給）wei3（偉葦委唯尾）tuei3（腿）nuei3（<b>餒</b>）luei3（壘儡）guei3（鬼軌癸詭晷）kuei3（傀愧）huei3（毀悔<b>賄</b>）shuei3（水）ruei3（蕊）zuei3（嘴）suei3（髓）bei4（背倍被貝狽輩備悖<b>婢</b>）pei4（配佩沛）mei4（妹昧寐媚）fei4（費沸廢<b>翡</b>吠肺）vei4（未味）wei4（為<b>偽</b>爲位胃蝟渭謂<b>緯偉</b>衛衞畏餵尉慰魏<b>穢</b>未味遺）duei4（對兌隊）tuei4（退）nuei4（內）luei4（類淚累）guei4（貴櫃桂跪<b>瑰</b>劊）kuei4（愧）huei4（会會繪<b>悔</b>晦彗慧諱惠滙匯彙卉穢）zhuei4（贅墜）shuei4（睡稅<b>瑞</b>）ruei4（銳）zuei4（最罪醉）cuei4（瘁翠粹悴啐）suei4（歲碎遂隧<b>髓</b>穂穗）au1（凹<b>坳</b>）bau1（包胞）pau1（拋）mau1（猫貓）dau1（刀）tau1（叨搯滔）lau1（撈）gau1（高篙膏羔餻糕）hau1（蒿）zhau1（招昭<b>抓</b>朝）chau1（鈔抄超<b>嘲</b>）shau1（燒梢）zau1（糟遭）cau1（<b>造</b>操）sau1（搔臊騷）yau1（<b>凹坳</b>夭妖幺么要腰邀）biau1（標彪）piau1（飄漂）diau1（刁叼凋雕貂）tiau1（挑）jiau1（交郊蛟嬌驕澆膠教）qiau1（敲）xiau1（鴞囂）ziau1（蕉礁焦椒）siau1（消宵銷硝逍霄簫蕭）pau2（袍匏庖<b>跑</b>）mau2（毛茅錨<b>猫貓</b>）tau2（逃桃萄淘<b>掏</b>陶<b>濤</b>）nau2（撓鐃）lau2（勞撈癆牢）ngau2（熬鼇鰲）hau2（毫豪號）chau2（朝潮巢）shau2（韶）rau2（饒）cau2（曹槽）yau2（搖遙窯謠堯姚肴）piau2（瓢嫖）miau2（苗描）tiau2（条條調）liau2（寥聊遼潦燎僚）qiau2（喬僑橋翹）xiau2（<b>肴</b>）ciau2（瞧樵憔）au3（襖）bau3（保堡飽寶宝）pau3（跑）mau3（卯昴）dau3（倒島搗擣禱）tau3（討）nau3（腦惱瑙）lau3（老）gau3（稿<b>皓</b>）kau3（攷考烤）hau3（好）zhau3（找爪抓）chau3（吵炒）shau3（少稍<b>紹</b>）rau3（擾<b>遶繞</b>）zau3（早棗澡蚤）cau3（草）sau3（嫂掃）yau3（咬杳窈）biau3（表）piau3（漂）miau3（秒渺眇藐）tiau3（眺）liau3（了）jiau3（攪矯狡皎餃）qiau3（巧）njiau3（鳥嬲）xiau3（曉嘵）ziau3（勦）ciau3（悄）siau3（小篠）au4（奧澳懊拗）bau4（抱鮑<b>雹</b>報暴爆豹）pau4（泡砲炮礟）mau4（冒帽貌）dau4（到倒道<b>導蹈</b>盜盗悼稻）tau4（套）nau4（鬧）lau4（勞）gau4（告）kau4（靠<b>烤</b>）ngau4（傲）hau4（號浩皓好耗）zhau4（召詔照兆趙肇）chau4（<b>鈔</b>）shau4（少紹<b>稍</b>）rau4（繞）zau4（造皁皂躁竈灶）cau4（<b>操糙</b>）sau4（<b>噪譟燥</b>）yau4（要耀曜燿<b>拗</b>）piau4（票漂）miau4（妙廟）diau4（吊弔釣調掉）tiau4（跳）liau4（料<b>療</b>）jiau4（叫呌教校較覺轎窖酵）qiau4（翹竅）njiau4（溺尿）xiau4（效効傚校孝）ciau4（俏誚）siau4（笑肖嘯）eu1（歐鷗區）deu1（兜）teu1（偷）leu1（摟）geu1（勾鉤鈎溝）heu1（<b>餱</b>）zheu1（州洲周週<b>鄒</b>舟）cheu1（抽<b>惆</b>）sheu1（收）seu1（搜颼）yeu1（憂優幽攸悠）dieu1（丟）lieu1（溜遛）jieu1（鳩）qieu1（丘邱蚯）xieu1（休）zieu1（啾揪揫）cieu1（秋鞦）sieu1（修脩羞）meu2（謀<b>矛</b>）feu2（<b>浮罘</b>）teu2（頭投）leu2（婁摟樓）heu2（侯猴喉）cheu2（愁籌躊綢酬仇讎讐惆）reu2（柔揉）yeu2（由油尤猶郵游遊<b>攸悠</b>）lieu2（流硫琉留榴劉）qieu2（求球裘毬仇）njieu2（牛）cieu2（囚酋）sieu2（囚）eu3（嘔<b>毆</b>）peu3（<b>剖</b>）meu3（某<b>牡母畝</b>）feu3（否<b>阜</b>）deu3（斗抖陡）leu3（簍摟）geu3（狗苟茍<b>垢</b>）keu3（口）ngeu3（偶藕）heu3（吼）zheu3（肘帚）cheu3（丑醜瞅）sheu3（手守首）zeu3（走）seu3（叟）yeu3（有友酉莠）lieu3（柳）jieu3（九久玖韭韮<b>糾</b>）njieu3（紐扭鈕）xieu3（朽）zieu3（酒）meu4（<b>牡茂貿戊</b>）feu4（<b>覆</b>）deu4（豆荳痘竇鬥鬭讀）teu4（透）leu4（漏陋）geu4（夠彀媾購構垢）keu4（扣叩寇）heu4（後候后厚<b>吼</b>）zheu4（宙胄晝縐皺咒）cheu4（臭）sheu4（受授壽售瘦獸<b>守</b>）reu4（肉）zeu4（奏）ceu4（凑湊）seu4（<b>漱</b>嗽）yeu4（又幼右佑柚宥誘）mieu4（謬）lieu4（溜）jieu4（救臼舅舊<b>究</b>咎柩）xieu4（臭嗅）zieu4（就）sieu4（秀袖岫绣繡銹鏽宿）an1（安鞍庵鵪諳）ban1（班斑般搬瘢）pan1（潘攀）fan1（番翻繙旙帆）dan1（單躭耽丹擔）tan1（<b>探</b>貪灘攤）gan1（干杆桿竿肝甘柑乾）kan1（堪勘刊看）zhan1（占沾毡氈瞻）chan1（攙）shan1（山删刪珊衫杉羶扇搧煽潸）zan1（簪）can1（餐參）san1（三叁<b>珊</b>）wan1（彎灣豌剜）duan1（端）guan1（官棺關觀鰥冠）kuan1（寬）huan1（歡）zhuan1（專甎磚）chuan1（川穿）shuan1（拴閂）zuan1（<b>攅</b>鑽鑚）suan1（酸）pan2（盤）man2（蔓饅瞞蠻）fan2（凡凢煩繁<b>藩帆</b>樊礬）tan2（談痰覃潭壇檀彈）nan2（南喃諵楠男難）lan2（闌蘭欄瀾攔藍籃<b>攬</b>欖濫）han2（寒含韓函涵）chan2（纏饞<b>纔</b>蟬）shan2（<b>禪蟬</b>）ran2（然燃）zan2（<b>咱喒偺</b>）can2（殘蠶慚）wan2（完頑丸）tuan2（團糰）luan2（鸞）huan2（還環鐶桓）chuan2（船椽傳）an3（俺唵）ban3（板版坂）man3（滿）fan3（反返）dan3（<b>担</b>胆膽）tan3（毯坦袒忐）lan3（懶嬾覽攬纜欖）gan3（敢橄趕感）kan3（砍坎侃）han3（喊罕）zhan3（展斬盞）chan3（產鏟剷懺）shan3（閃陝<b>潸</b>）ran3（染）can3（慘）san3（傘散繖）wan3（宛碗晚挽輓<b>娩</b>）duan3（短）nuan3（暖煖）luan3（卵）guan3（管館舘）kuan3（款）huan3（緩）zhuan3（轉）chuan3（喘舛）ruan3（輭軟）zuan3（<b>躦</b>纂）an4（按案暗<b>諳</b>）ban4（半伴拌辦瓣扮）pan4（判胖叛畔盼）man4（慢漫幔僈）fan4（飯販犯范範梵泛帆）dan4（旦但担蛋誕淡彈憚擔）tan4（探炭歎嘆）nan4（難）lan4（爛濫<b>纜</b>）gan4（幹贛）kan4（<b>勘嵌</b>看）ngan4（岸）han4（漢汗罕旱悍翰憾）zhan4（占站佔戰棧顫綻）chan4（懺）shan4（善鱔膳扇煽疝禪擅）zan4（暫贊讚）can4（燦）san4（散<b>三</b>）wan4（腕<b>玩</b>萬万卍）duan4（斷段緞）luan4（亂乱）guan4（貫慣灌觀礶罐冠）huan4（幻患宦喚換）zhuan4（轉傳賺撰篆）chuan4（串）zuan4（鑽）cuan4（竄篡）suan4（算祘蒜）ian1（咽烟煙奄淹醃焉<b>鹽</b>）bian1（扁邊編蝙鞭）pian1（扁偏篇）dian1（顛巔癲）tian1（天添）jian1（兼監堅肩艱間姦奸緘）qian1（牽鉛謙）njian1（拈）xian1（<b>軒</b>掀）zian1（尖煎箋濺漸）cian1（千遷韆僉簽籖）sian1（先仙鮮纖暹）yuan1（冤淵鴛）jyuan1（捐娟鵑）qyuan1（圈）xyuan1（喧萱）cyuan1（<b>痊詮</b>）syuan1（宣）ian2（言鹽沿嚴岩巌顏炎延筵蜒研閻檐<b>焉</b>）pian2（便）mian2（眠棉綿緜）tian2（田鈿甜填）lian2（連鰱蓮廉簾憐聯）qian2（鉗乾）njian2（年黏粘<b>拈</b>）xian2（咸鹹嫌賢弦舷絃啣銜閑閒）cian2（前錢潜潛）sian2（涎）yuan2（元黿原源員圓園袁緣猿轅垣<b>鳶</b>媛援鉛）qyuan2（拳權）xyuan2（玄懸）cyuan2（全泉）syuan2（旋）ian3（眼演掩儼衍奄）bian3（扁匾）mian3（免勉冕娩）dian3（點<b>玷</b>典）tian3（<b>䑛舐</b>忝）lian3（臉）jian3（减減柬揀簡繭鹼堿檢儉<b>臉</b>）qian3（<b>歉</b>遣）njian3（碾輦攆）xian3（險顯）zian3（剪餞<b>踐</b>）cian3（淺）sian3（癬鮮銑跣）yuan3（遠阮）jyuan3（卷捲）qyuan3（犬）syuan3（選）ian4（燕嚥雁鴈彥諺厭驗宴硯<b>衍</b>艷豔）bian4（变變便卞徧遍辨辮辯）pian4（片騙<b>諞</b>）mian4（面麵麫）dian4（電墊店惦殿甸奠靛）tian4（<b>忝</b>）lian4（<b>斂</b>殮鍊鏈煉練）jian4（見建健鍵<b>儉</b>諫劍件監鑑艦間鑒）qian4（欠縴歉<b>遣</b>）njian4（念廿卄）xian4（現見莧限縣憲餡豏陷献獻）zian4（箭漸薦僭賤濺餞踐）sian4（線綫羨霰）yuan4（怨院願<b>媛援</b>）lyuan4（戀）jyuan4（卷倦眷絹）qyuan4（券勸）xyuan4（眩）en1（恩）ben1（奔）pen1（噴）fen1（分吩<b>墳</b>紛芬）gen1（根跟）zhen1（斟臻榛珍真針）chen1（參）shen1（伸參呻申<b>森</b>深紳身）cen1（參）pen2（盆）men2（們門）fen2（焚）hen2（痕）chen2（<b>岑</b>晨沉臣辰陳塵）shen2（神）ren2（人仁任壬妊<b>恁</b>）ben3（本）fen3（粉）ken3（墾懇）hen3（很狠）zhen3（朕枕疹診）shen3（嬸審沈）ren3（<b>妊</b>忍<b>恁</b>衽）zen3（怎）ben4（笨）men4（悶）fen4（奮分忿憤糞）hen4（恨）zhen4（振<b>椹診</b>賑鎮震陣朕）chen4（櫬襯趁）shen4（慎甚腎）ren4（任刃妊<b>椹</b>衽認<b>賃</b>）men（們）in1（因姻茵音殷陰）bin1（賓濱檳彬斌）jin1（斤觔今衿襟筋巾金禁）qin1（欽衾）xin1（欣）zin1（津）cin1（親侵）sin1（心辛新薪）in2（銀寅吟淫迎）pin2（貧頻<b>蘋</b>顰）min2（民岷<b>閩</b>）nin2（您）lin2（林淋霖鄰麟燐磷鱗臨）qin2（琴禽擒勤芹）cin2（秦）sin2（<b>尋</b>）in3（飲隱尹引蚓）bin3（稟）pin3（品<b>牝</b>）min3（閔憫敏泯）lin3（廩<b>吝</b>）jin3（緊錦謹）zin3（儘）cin3（寢）in4（<b>飲蔭</b>印吟）bin4（鬢殯）lin4（賃吝）jin4（近<b>僅</b>禁噤）xin4（釁）zin4（盡燼晉浸進）cin4（親沁）sin4（信訊）un1（溫瘟）dun1（敦墩蹲）tun1（吞）kun1（昆崑坤）hun1（昏婚惛閽葷）zhun1（屯諄）chun1（春椿）zun1（尊遵樽）cun1（村皴）sun1（孫猻）un2（文蚊紋聞）tun2（屯飩豚臀）lun2（侖輪淪倫崙論）hun2（渾琿魂餛）chun2（脣唇純鶉）shun2（蒓）cun2（存）un3（穩吻刎）dun3（躉）gun3（滾）kun3（綑捆悃）hun3（混）zhun3（准準）chun3（蠢）dun3（盾）cun3（忖）sun3（損筍笋）un4（<b>紊聞</b>問）dun4（鈍頓盾遁）tun4（<b>褪</b>）nun4（<b>嫩</b>）lun4（論）gun4（棍）kun4（困）hun4（混）shun4（順舜瞬）run4（閏潤）cun4（寸）sun4（<b>遜</b>）yun1（氳）jyun1（君均鈞軍）xyun1（薰勳勛）zyun1（竣）syun1（洵筍<b>荀詢</b>）yun2（云雲耘勻）qyun2（羣群裙）syun2（旬徇循巡馴）yun3（允）jyun3（<b>窘菌</b>）yun4（韵韻<b>隕</b>暈運孕慍熨）jyun4（郡菌）xyun4（訓）zyun4（俊峻）syun4（殉馴）ang1（骯）bang1（邦梆帮幫）pang1（乓滂）fang1（方<b>妨坊肪</b>芳）dang1（當<b>檔</b>襠）tang1（湯）lang1（啷）gang1（岡鋼綱剛肛缸）kang1（康糠慷）zhang1（張章樟璋彰）chang1（昌倡娼）shang1（商傷觴）zang1（臧贓髒）cang1（倉艙蒼滄）sang1（桑喪）yang1（央泱秧殃鴦）jiang1（江姜彊疆韁僵薑）qiang1（腔）xiang1（香鄉）ziang1（將漿）ciang1（槍鎗）siang1（相箱湘廂襄鑲）wang1（汪）guang1（光胱）kuang1（匡筐）huang1（慌荒）zhuang1（裝莊妝粧椿）chuang1（窗瘡創）shuang1（霜孀雙双）pang2（旁<b>傍</b>徬彷膀螃龐<b>彭</b>）mang2（忙茫盲氓）fang2（防肪房坊）tang2（堂棠螳唐塘糖）nang2（囊）lang2（郎廊螂狼瑯榔蜋）kang2（扛）ngang2（昂）hang2（杭航行降）chang2（常嘗嫦償腸<b>場塲</b>長）shang2（<b>裳尚</b>）rang2（瓤）cang2（藏）yang2（羊洋佯禓陽揚楊）liang2（凉涼諒梁粱良量糧）qiang2（強）njiang2（娘）xiang2（降）ciang2（墻牆）siang2（詳祥翔）wang2（王亡忘）kuang2（狂）huang2（黃簧磺皇凰煌惶蝗徨遑）chuang2（床牀）bang3（磅榜<b>鎊謗</b>髈綁）pang3（<b>鎊</b>）mang3（莽）fang3（仿訪倣紡彷髣）dang3（黨擋）tang3（倘躺）lang3（朗）gang3（港）kang3（<b>慷</b>）zhang3（掌長）chang3（敞廠場塲）shang3（賞）rang3（嚷）sang3（嗓顙）yang3（養癢仰）liang3（兩<b>輛</b>）jiang3（講）qiang3（強）xiang3（響嚮饗享）ziang3（蔣將獎槳）ciang3（搶）siang3（想鯗）wang3（往枉罔網惘）guang3（廣）huang3（恍謊）chuang3（闖）shuang3（爽）bang4（棒蚌傍謗）pang4（胖）fang4（放<b>訪</b>）dang4（當擋宕蕩盪）tang4（燙趟）lang4（浪）gang4（<b>虹肛</b>）kang4（炕抗伉慷）hang4（<b>項</b>）zhang4（丈仗杖賬漲脹帳障瘬）chang4（唱倡暢悵）shang4（上尚償）rang4（讓）zang4（藏臟葬）cang4（愴）sang4（喪）yang4（樣漾恙）liang4（亮諒量）jiang4（強降絳虹）njiang4（釀）xiang4（巷向嚮<b>餉</b>項饗）ziang4（將醬匠）ciang4（嗆）siang4（象像橡相）wang4（望旺妄忘）guang4（逛）kuang4（礦曠况況<b>誑</b>貺）zhuang4（撞壯狀）chuang4（創撞）eng1（<b>哼</b>鞥）beng1（崩繃）peng1（烹<b>乓</b>）deng1（登燈）geng1（庚賡更羹耕）keng1（坑阬硜）heng1（亨哼）zheng1（正征爭箏睜<b>貞偵</b>徵蒸）cheng1（稱撐撑蟶）sheng1（声聲生笙牲甥升勝）reng1（扔）zeng1（曾增憎）seng1（僧）peng2（朋棚鵬彭）meng2（萌盟氓）teng2（疼滕藤籐騰謄）neng2（能）leng2（稜）heng2（橫恆恒衡）cheng2（成城誠盛乘丞承呈程橙澄）sheng2（繩）reng2（仍）ceng2（曾層）meng3（猛）deng3（等戥）leng3（冷）geng3（梗耿）keng3（<b>肯</b>）zheng3（整拯）cheng3（逞）sheng3（省）beng4（迸）peng4（掽碰）meng4（孟）deng4（凳瞪鄧<b>澄</b>）geng4（更<b>亘亙</b>）zheng4（正症政<b>倀</b>証證鄭）cheng4（<b>乘稱</b>秤）sheng4（勝聖剩盛）zeng4（贈）ing1（應鷹嬰櫻纓鸚鶯英）bing1（冰氷兵<b>屏并幷</b>）ping1（<b>拼</b>乒）ding1（丁叮仃釘）ting1（聽听廳汀町）jing1（京經驚荊）qing1（卿<b>頃</b>傾輕）xing1（<b>馨</b>興）zing1（精<b>蜻</b>睛晶旌）cing1（青清）sing1（星<b>醒</b>腥猩）ing2（迎蠅盈贏嬴螢營）ping2（平評萍瓶屏憑）ming2（名銘明鳴冥）ting2（亭停廷庭霆蜓）ling2（令鈴零伶羚齡陵菱靈）qing2（<b>鯨</b>）njing2（甯寧檸擰凝）xing2（行形刑型）cing2（情晴）ing3（影穎）bing3（<b>并幷</b>餅丙秉）ming3（<b>皿</b>冥）ding3（頂鼎）ting3（挺艇町）ling3（領嶺）jing3（景頸<b>莖境</b>警）qing3（頃<b>傾罄</b>）zing3（井阱）cing3（請）sing3（醒省）ing4（應硬映）bing4（并幷<b>屏</b>併並病<b>柄</b>）ping4（<b>聘娉評</b>屏）ming4（命）ding4（訂釘定<b>靛</b>錠）ting4（聽听艇）ling4（令另）jing4（敬<b>儆</b>竟競<b>勁</b>徑逕鏡）qing4（慶罄磬）xing4（行杏幸倖興）zing4（净凈淨靜靖）sing4（性姓)ung1（翁）fung1（風楓<b>諷</b>瘋丰夆峰峯烽鋒蜂豐封）dung1（東冬鼕）tung1（通）gung1（工攻功公蚣弓躬供龔恭宮觥）kung1（空）hung1（轟烘）zhung1（中忠盅衷終鐘鍾）chung1（冲沖忡充舂衝）zung1（宗椶蹤踪<b>縱</b>）cung1（匆怱葱蔥聰<b>從</b>）sung1（松鬆嵩）yung1（雍）jyung1（扃）qyung1（<b>穹</b>）xyung1（兄凶兇匈胸）bung2（甭）pung2（蓬篷）mung2（蒙朦濛矇）fung2（逢縫馮）tung2（同㒰仝桐銅<b>筒</b>衕童僮瞳筩）nung2（農儂濃膿）lung2（龍聾攏籠朧嚨隆）hung2（紅虹洪弘宏鴻）chung2（蟲崇重）rung2（戎絨茸）cung2（從从叢）sung2（<b>松</b>）yung2（榮容蓉溶鎔<b>庸傭</b>融）qyung2（窮瓊）xyung2（熊雄）pung3（捧）dung3（董懂）tung3（桶統）lung3（攏壟隴）gung3（拱）kung3（孔恐）hung3（哄）zhung3（種腫）chung3（寵衝）zung3（總）sung3（悚）yung3（永泳詠咏勇湧蛹踊擁）jyung3（迥炯扃）ung4（甕）bung4（蹦）mung4（夢）fung4（奉俸<b>諷</b>鳳）dung4（洞動凍棟）tung4（痛衕<b>統</b>）lung4（<b>弄衖閧</b>）gung4（共供貢汞）kung4（空控）hung4（哄鬨<b>汞</b>）zhung4（重仲眾衆種中）chung4（銃）zung4（粽糉糭縱從）sung4（送宋訟頌誦）yung4（用<b>泳詠咏</b>）jyung4（<b>扃</b>）";
    //来源: https://zh.wikiversity.org/wiki/%E6%95%B4%E5%90%88%E8%80%81%E5%9C%8B%E9%9F%B3%E7%86%9F%E5%AD%97%E5%BD%99
    public static final List<String[]> data_zhuyin = new ArrayList<>();

    private View root; //控件
    private EditText text;
    private Switch replace;
    private boolean zhuyin = false;

    private Runnable s; //搜索程序

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lauguoyin, container, false);
        text = (EditText) root.findViewById(R.id.shit2);
        replace = (Switch) root.findViewById(R.id.replace);

        s = new Runnable() {
            @Override
            public void run() {
                text.setText(dealString(text.getText().toString(),zhuyin,replace.isChecked()));
            }
        };


        ((Button) root.findViewById(R.id.zhuyin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    zhuyin = true;
                    new Thread(s).start();
                }catch (Exception e){}
            }
        });
        ((Button) root.findViewById(R.id.pinyin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    zhuyin = false;
                    new Thread(s).start();
                }catch (Exception e){}
            }
        });
        ((Button) root.findViewById(R.id.clear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
            }
        });

        return root;
    }


    public static final SpannableString dealString(String pre, boolean zhuyin, boolean replace_with_n){
        String a = ZHConverter.convert(pre, ZHConverter.TRADITIONAL);
        String b = "";
        List<int[]> red = new ArrayList<>();
        List<int[]> blue = new ArrayList<>();


        for (int i = 0; i < a.length(); i++) {
            String t = a.substring(i, i + 1);
            if(!common.isChinese(t.toCharArray()[0])) //非中文
                continue;

            int index = data.indexOf(t);
            if(index != -1){
                try {
                    String before = data.substring(0, index); //用于向前搜索
                    String pinyin = data.substring(
                            before.lastIndexOf("）") + 1,
                            before.lastIndexOf("（")
                    );
                    /*
                    if(a.substring(i+1,i+2).equals("兒")){ //儿化音
                        i++;
                        t+="儿";

                        String end = pinyin.substring(pinyin.length()-1,pinyin.length());
                        if(end.equals("1")||end.equals("2")||end.equals("3")||end.equals("4")){
                            pinyin=pinyin.substring(0,pinyin.length()-1)+"r"+end;
                        }else
                            pinyin+="r";
                    }*/

                    pinyin = pinyin
                            .replace("1","¹")
                            .replace("2","²")
                            .replace("3","³")
                            .replace("4","⁴")
                            .replace("5","⁵");

                    if(zhuyin) //转注音
                        pinyin = toZhuyin(pinyin, replace_with_n);

                    String out = t+"("+pinyin+")";
                    int d1 = before.lastIndexOf("<b>"); //是否和今音不同
                    int d2 = before.lastIndexOf("</b>");
                    if(d1!=-1 && d2<d1){
                        red.add(new int[]{b.length(),b.length()+out.length()}); // inclusive_exclusive
                        b+=out;
                    }else{
                        b+=out;
                    }

                    continue;

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            blue.add(new int[]{b.length(),b.length()+t.length()}); // inclusive_exclusive
            b+=t; //沒有匹配項
        }
        SpannableString c = new SpannableString(b);
        for(int[] red0 : red){
            c.setSpan(new ForegroundColorSpan(Color.RED), red0[0], red0[1], Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        for(int[] blue0 : blue){
            c.setSpan(new ForegroundColorSpan(Color.BLUE), blue0[0], blue0[1], Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        return c;
    }

    public static final String toZhuyin(String dealedString, boolean replace_with_n){
        String a = dealedString;
        for(String[] convert : data_zhuyin){
            a = a.replace(convert[0],convert[1]);
        }
        return replace_with_n ? a.replace('ㄬ','ㄋ') : a;
    }

    private static final String FONT_REPLACEMENT = "<font color='%1$s'>%2$s</font>";
    private static final String red(String r){
        return String.format(FONT_REPLACEMENT, Color.RED, r);
    }
    private static final String blue(String r){
        return String.format(FONT_REPLACEMENT, Color.BLUE, r);
    }

    public static final void initData(){
        data_zhuyin.add(new String[]{"ung","ㄨㄥ"});data_zhuyin.add(new String[]{"yung","ㄩㄥ"});
        data_zhuyin.add(new String[]{"ung","ㄨㄥ"});
        data_zhuyin.add(new String[]{"ing","ㄧㄥ"});
        data_zhuyin.add(new String[]{"iang","ㄧㄤ"});
        data_zhuyin.add(new String[]{"yang","ㄧㄤ"});
        data_zhuyin.add(new String[]{"ang","ㄤ"});
        data_zhuyin.add(new String[]{"eng","ㄥ"});
        data_zhuyin.add(new String[]{"in","ㄧㄣ"});
        data_zhuyin.add(new String[]{"un","ㄨㄣ"});
        data_zhuyin.add(new String[]{"yun","ㄩㄣ"});
        data_zhuyin.add(new String[]{"yu","ㄩ"});
        data_zhuyin.add(new String[]{"an","ㄢ"});
        data_zhuyin.add(new String[]{"en","ㄣ"});
        data_zhuyin.add(new String[]{"ou","ㄡ"});
        data_zhuyin.add(new String[]{"au","ㄠ"});
        data_zhuyin.add(new String[]{"ai","ㄞ"});
        data_zhuyin.add(new String[]{"ei","ㄟ"});
        data_zhuyin.add(new String[]{"eu","ㄡ"});
        data_zhuyin.add(new String[]{"ng","ㄫ"});
        data_zhuyin.add(new String[]{"chi","ㄔ"});
        data_zhuyin.add(new String[]{"shi","ㄕ"});
        data_zhuyin.add(new String[]{"ri","ㄖ"});
        data_zhuyin.add(new String[]{"chi","ㄔ"});
        data_zhuyin.add(new String[]{"sh","ㄕ"});
        data_zhuyin.add(new String[]{"zh","ㄓ"});
        data_zhuyin.add(new String[]{"r","ㄖ"});
        data_zhuyin.add(new String[]{"o","ㄛ"});
        data_zhuyin.add(new String[]{"eo","ㄜ"});
        data_zhuyin.add(new String[]{"e","ㄝ"});
        data_zhuyin.add(new String[]{"u","ㄨ"});
        data_zhuyin.add(new String[]{"a","ㄚ"});
        data_zhuyin.add(new String[]{"zi","ㄗ"});
        data_zhuyin.add(new String[]{"ci","ㄘ"});
        data_zhuyin.add(new String[]{"si","ㄙ"});
        data_zhuyin.add(new String[]{"z","ㄗ"});
        data_zhuyin.add(new String[]{"c","ㄘ"});
        data_zhuyin.add(new String[]{"s","ㄙ"});
        data_zhuyin.add(new String[]{"b","ㄅ"});
        data_zhuyin.add(new String[]{"p","ㄆ"});
        data_zhuyin.add(new String[]{"m","ㄇ"});
        data_zhuyin.add(new String[]{"f","ㄈ"});
        data_zhuyin.add(new String[]{"v","ㄪ"});
        data_zhuyin.add(new String[]{"d","ㄉ"});
        data_zhuyin.add(new String[]{"t","ㄊ"});
        data_zhuyin.add(new String[]{"n","ㄬ"});
        data_zhuyin.add(new String[]{"l","ㄌ"});
        data_zhuyin.add(new String[]{"g","ㄍ"});
        data_zhuyin.add(new String[]{"k","ㄎ"});
        data_zhuyin.add(new String[]{"h","ㄏ"});
        data_zhuyin.add(new String[]{"j","ㄐ"});
        data_zhuyin.add(new String[]{"q","ㄑ"});
        data_zhuyin.add(new String[]{"x","ㄒ"});
        data_zhuyin.add(new String[]{"w","ㄨ"});
        data_zhuyin.add(new String[]{"yi","ㄧ"});
        data_zhuyin.add(new String[]{"i","ㄧ"});
        data_zhuyin.add(new String[]{"y","ㄧ"});
        data_zhuyin.add(new String[]{"r","ㄦ"});

    }

}

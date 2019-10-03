package com.example.asus.baitap;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class    Main2Activity extends AppCompatActivity {
    ListView lvPhim;
    TextView txtPhimDialog;
    ArrayList<Phim> arrPhimKinhDi;
    ArrayList<Phim> arrPhimHanhDong;
    ArrayList<Phim> arrPhimHan;
    ArrayList<Phim> arrPhimAuMi;
    ArrayList<Phim> arrPhimHoatHinh;
    ArrayList<Phim> arrPhimTinhCam;
    ArrayList<Phim> arrPhimVienTuong;
    PhimAdapter adapter;
    int kt=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findId();
        Intent nhan= getIntent();

        Bundle bundle= nhan.getBundleExtra("chuyenchuoi");
//        Intent nhan2=new Intent(Main2Activity.this,Main3Activity.class);
//        startActivity(nhan2);
        if(bundle!=null){
            if(bundle.getString("chuoi").equals("1")==true){
                adapter = new PhimAdapter(this,R.layout.list_phim,arrPhimHanhDong);
                lvPhim.setAdapter(adapter);
                lvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Dialog(position,arrPhimHanhDong);
                        if(kt==1){


                        }

                    }
                });
            }
            if(bundle.getString("chuoi").equals("2")==true){
                adapter = new PhimAdapter(this,R.layout.list_phim,arrPhimTinhCam);
                lvPhim.setAdapter(adapter);
                lvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Dialog(position,arrPhimTinhCam);

                    }
                });
            }
            if(bundle.getString("chuoi").equals("3")==true){
                adapter = new PhimAdapter(this,R.layout.list_phim,arrPhimVienTuong);
                lvPhim.setAdapter(adapter);
                lvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Dialog(position,arrPhimVienTuong);

                    }
                });
            }
            if(bundle.getString("chuoi").equals("4")==true){
                adapter = new PhimAdapter(this,R.layout.list_phim,arrPhimKinhDi);
                lvPhim.setAdapter(adapter);
                lvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Dialog(position,arrPhimKinhDi);

                    }
                });
            }
            if(bundle.getString("chuoi").equals("5")==true){
                adapter = new PhimAdapter(this,R.layout.list_phim,arrPhimHoatHinh);
                lvPhim.setAdapter(adapter);
                lvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Dialog(position,arrPhimHoatHinh);

                    }
                });
            }
            if(bundle.getString("chuoi").equals("6")==true){
                adapter = new PhimAdapter(this,R.layout.list_phim,arrPhimHan);
                lvPhim.setAdapter(adapter);
                lvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Dialog(position,arrPhimHan);

                    }
                });
            }
            if(bundle.getString("chuoi").equals("7")==true){
                adapter = new PhimAdapter(this,R.layout.list_phim,arrPhimAuMi);
                lvPhim.setAdapter(adapter);
                lvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Dialog(position,arrPhimAuMi);

                    }
                });
            }

        }


    }

    private void Dialog(final int i, final ArrayList<Phim> a){
        AlertDialog.Builder alDialog=new AlertDialog.Builder(this);
        alDialog.setTitle("Hãy Chọn Thao Tác!!");
        alDialog.setIcon(R.mipmap.ic_launcher_round);
        alDialog.setPositiveButton("Xóa Phim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                xoaDialog(i,a);



            }

        });
        alDialog.setNegativeButton("Xem Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent a=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(a);

            }
        });


        alDialog.show();

    }
    private void xoaDialog(final int i2, final ArrayList<Phim> a2){
        AlertDialog.Builder alDialog=new AlertDialog.Builder(this);
        alDialog.setTitle("Bạn có chắc chắn muốn xóa!");
        alDialog.setIcon(R.mipmap.ic_launcher_round);
        alDialog.setPositiveButton("có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                a2.remove(i2);
                adapter.notifyDataSetChanged();
            }
        });
        alDialog.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alDialog.show();


    }
    private void findId(){
        txtPhimDialog=(TextView)findViewById(R.id.txtPhim_dialog);
        lvPhim = (ListView) findViewById(R.id.listPhim);
        AuMi();
        TinhCam();
        PhimHan();
        HanhDong();
        HoatHinh();
        VienTuong();
        KinhDi();






    }
    private void AuMi(){
        arrPhimAuMi=new ArrayList<>();
        arrPhimAuMi.add(new Phim("Titanic (1997)",
                "Titanic bộ phim thảm họa và lãng mạn có yếu tố lịch sử của Mỹ phát hành năm 1997, do đạo diễn James Cameron làm đạo diễn, viết kịch bản, đồng sản xuất,biên tập và hỗ trợ tài chính một phần.","nhan vat1,nhanvat2",
                R.drawable.am1
                ,"YQB_Dzyo0DE"));
        arrPhimAuMi.add(new Phim("One Day (2011)",
                "Câu chuyện kể về chuyện tình yêu giữa Dexter và Emma – Một hành trình yêu 20 năm. Đây là một câu chuyện rất lạ, cả hai cùng có tình cảm với nhau, nhưng lại luôn tự nghĩ “Mình chỉ là bạn”. Câu chuyện khiến người coi phải thấp thỏm, luyến tiếc khi mãi cả hai vẫn không đến với nhau trong  suốt 20 năm.","nhanvat1,nhanvat2"
                ,R.drawable.am2
                ,""));
        arrPhimAuMi.add(new Phim("One Day (2011)",
                "Never let me go, bộ phim đạo diễn Mark Romanek với diễn viên Carey Mulligan, Keira Knightley và Andrew Garfield đã nhận được lời khen ngợi và trở thành bộ phim cực kỳ hấp dẫn.\n" +
                        "\n" +
                        "Bộ phim kể về những  câu chuyện tình yêu của tuổi trẻ, thể hiện sự bồng bột và những cao ngạo của tuổi trẻ. Đan xen vào bộ phim là những chia ly hay sự luyến tiếc về một thời trẻ tuổi. Bộ phim kết thúc một cách đầy lẻ loi với hình ảnh nhân vật chính Kathy khi mọi người xung quanh cô lần lượt rời đi.","nhanvat1,nhanvat2"
                ,R.drawable.am3
                ,""));
        arrPhimAuMi.add(new Phim("Atonement (2007)",
                "Đây là một câu chuyện tình đẹp vượt giai cấp giữa nàng Cecillia và chàng giúp việc Robbie. Đây là một chuyện tình đầy đẹp đẽ và thi vị.  Nhưng đồng thời cũng là chuyện tình đau khổ nhất trên màn ảnh. Bộ phim đã kết thúc một cách đầy đau xót với cái chết của 2 nhân vật chính trong sự chia xa đầy đau buồn.","nhan vat1,nhanvat2",
                R.drawable.am4
                ,""));
    }
    private void TinhCam(){
        arrPhimTinhCam=new ArrayList<>();
        arrPhimTinhCam.add(new Phim("In The Mood For Love (Tâm trạng khi yêu - 2001)"
                ,"Đây là bộ phim kinh điển của điện ảnh Hong Kong của đạo diễn Vương Gia Vệ với hai diễn viên chính Lương Triều Vỹ và Trương Mạn Ngọc. Những cảm xúc yêu đương mãnh liệt, không thể vượt qua rào cản xã hội và không thể giãi bày nhưng hai nhân vật chính trong phim đã để lại sự nuối tiếc đẹp đẽ cho khán giả. Tác phẩm của đạo diễn họ Vương luôn nằm trong top những phim tình cảm vĩ đại nhất mọi thời đại. "
                ,"nhan vat 1,nhan vat 2"
                ,R.drawable.tc1
                ,""));
        arrPhimTinhCam.add(new Phim("Lost in Translation (Lạc lối ở Tokyo - 2003)"
                ,"Phim kể về cuộc gặp gỡ tình cờ của hai con người xa lạ, trên một đất nước xa lạ. Một người là ngôi sao điện ảnh hết thời (Bill Murry đóng) đang gặp “khủng hoảng tuổi trung niên”, một người là cô sinh viên (Scarlett Johansson đóng) vừa tốt nghiệp và vỡ mộng trước hôn nhân. Ở một thành phố xa lạ, họ trở nên cô đơn, lạc lõng, và khao khát được sẻ chia tâm sự. Bộ phim của nữ đạo diễn Sofia Coppola đã giành giải Kịch bản gốc xuất sắc nhất tại Oscar, được đề cử Quả cầu vàng hạng mục phim truyện và diễn xuất. "
                ,"nhan vat 1,nhan vat 2"
                ,R.drawable.tc2
                ,""));
        arrPhimTinhCam.add(new Phim("ays of Summer (2009)"
                ,"Chuyện phim kể về anh chàng Tom Hansen và 500 ngày ở bên cô gái xinh đẹp Summer Finn. Dù có khoảng thời gian thật hạnh phúc nhưng Tom và Summer vẫn chia tay vì tư tưởng khác biệt trong tình yêu. Summer không tin vào tình yêu đích thực và hôn nhân, còn Tom thì ngược lại. Ngoài giải Kịch bản gốc xuất sắc\" của giải thưởng Tinh thần độc lập, phim cũng nhận đề cử \"Phim ca nhạc/hài hước xuất sắc\" ở Quả cầu vàng."
                ,"nhan vat 1,nhan vat 2"
                ,R.drawable.tc3
                ,""));
        arrPhimTinhCam.add(new Phim("Amour (2012)"
                ,"Bộ phim lãng mạn của nước Pháp đơn giản kể lại cuộc sống của cặp vợ chồng lớn tuổi, Anne và Georges, trong một ngôi nhà ấm áp tại Paris. Đến một ngày, cơn đột quỵ khiến Anne bị liệt nửa người, mọi hoạt động đều trông cậy vào Georges, và một lần nữa họ phải trải qua những thử thách để rồi cuối cùng lại chứng minh tình yêu có thể vượt lên trên tất cả. Amour đã giành giải Cành cọ vàng lại liên hoan phim Cannes, giải César và được đề cử Oscar cho phim xuất sắc nhất. "
                ,"nhan vat 1,nhan vat 2"
                ,R.drawable.tc4
                ,""));


    }
    private void PhimHan(){
        arrPhimHan=new ArrayList<>();

        arrPhimHan.add(new Phim("Descendants Of The Sun"
                ,"Thu hút người xem với chuyện tình chàng quân nhân Yoo Si Jin (Song Joong Ki) và cô nàng bác sĩ Kang Mo Yeon (Song Hye Kyo) cùng với tuyến nhân vật phụ cá tính, bộ phim đã trở thành hiện tượng đối với khán giả ở cả 19 nước trong và ngoài châu Á. Không chỉ vậy, “Hậu duệ của mặt trời” còn từng được Tổng thống Hàn Quốc vinh danh, Thủ tướng Thái Lan khen ngợi và toàn thể quân đội Trung Quốc phải ngưỡng mộ. Bộ phim xứng đáng xếp vị trí số 1 trong bảng xếp hạng này"
                ,"Song Joong Ki,Song Hye Kyo"
                ,R.drawable.ph1
                ,""));
        arrPhimHan.add(new Phim("My Love From the Star"
                ,"“Vì sao đưa anh tới” kể về chuyện tình cụ giáo Do Min Joon (Kim Soo Hyun) và mợ chảnh đại minh tinh Chun Song Yi (Jun Ji Hyun), cốt phim mới lạ đã thu hút nhiều sự chú ý của người xem. Bộ phim là đã đánh dấu cho sự nghiệp diễn xuất của Kim Soo Hyun, đưa anh trở thành ‘nam thần’ được yêu thích nhất tại Hàn Quốc, Trung Quốc, Singapore… lúc bấy giờ."
                ,"Jun Ji Hyun,Kim Soo Hyun"
                ,R.drawable.ph2
                ,""));
        arrPhimHan.add(new Phim("The Heirs"
                ,"“Những người thừa kế” với sự diễn xuất của Park Shin Hye, Lee Min Ho và Kim Woo Bin nhanh chóng trở thành bộ phim đình đám chỉ sau vài tập phát sóng. Rating của bộ phim luôn ở mức hai con số, trung bình khoảng 16%. Bộ phim đã đánh dấu thành công mới trong diễn xuất của Lee Min Ho sau “Vườn sao băng” từng gây sốt một thời. Đồng thời, bộ phim cũng đưa tên tuổi của các diễn viên: Kim Woo Bin, Kim Ji Won... đến gần hơn với quý vị khán giả."
                ,"Lee Min Ho,Park Shin Hye"
                ,R.drawable.ph3
                ,""));
        arrPhimHan.add(new Phim("Boys Over Flowers"
                ,"“Vườn sao băng” là bộ phim dựa trên cuốn truyện tranh “Con nhà giàu” (Hana Yori Dango) của tác giả Yoko Kamio, bộ phim chính là bệ phóng cho nhiều diễn viên đình đám hiện nay: Lee Min Ho, Goo Hye Sun, Kim Bum, Kim So Eun… Mức rating trung bình của bộ phim vào khoảng 28.5%, có tập cao nhất lên đến 35.5%."
                ,"Lee Min Ho,Kim Bum"
                ,R.drawable.ph4
                ,""));


    }
    private void HanhDong(){
        arrPhimHanhDong=new ArrayList<>();
        arrPhimHanhDong.add(new Phim("Thor: Ragnarok"
                ,"Thor: Ragnarok là bộ phim được đầu tư kinh phí cao đứng thứ 7 trong Vũ trụ Điện ảnh Marvel với 180 triệu USD nhưng rất đáng đồng tiền bát gạo. Bằng chứng là Thor: Ragnarok không chỉ được xem là tác phẩm hài hước nhất của series Thor mà còn của cả MCU từ trước đến nay với cơn mưa lời khen không ngớt.\n" +
                "\n" +
                "Thậm chí, Thor: Ragnarok đã nhận được 98% số điểm tích cực với gần một trăm lời nhận xét, đánh giá trên Rotten Tomatoes đấy."
                ,"Marvel"
                ,R.drawable.hd1
                ,""));
        arrPhimHanhDong.add(new Phim("Captain America: The Winter Soldier"
                ,"Không hề quá khi nói Captain America: The Winter Soldier sở hữu tất cả những gì khán giả cần ở một bộ phim bom tấn siêu anh hùng: cuốn hút, hồi hộp, với nội dung có chiều sâu và những cảnh hành động hoành tráng.\n" +
                "\n" +
                "Bộ phim đã khắc họa rõ nét hình tượng một siêu anh hùng cổ điển, giản dị, trung thực, dũng cảm, và đặt lòng yêu nước lên trên hết, Steve Rogers – Captain America xứng đáng được đặt ở vị trí đầu tàu, dẫn dắt các người hùng khác dù không hề sở hữu năng lực khủng khiếp nào đó."
                ,"Marvel"
                ,R.drawable.hd2
                ,""));
        arrPhimHanhDong.add(new Phim("The avengers:end game"
                ,"The Avengers là thời điểm MCU chính thức đưa tất cả các siêu anh hùng được giới thiệu trước đó quy tụ trong một bộ phim. Từ đó, giấc mơ về những người phi thường sát cánh bên nhau cùng chiến đấu đã không còn là viển vông trong vũ trụ điện ảnh Marvel.\n" +
                "\n" +
                "Thử nghĩ mà xem, nhìn thấy một siêu anh hùng đã làm bạn sướng đến khi thấy họ đứng bên nhau cùng bảo vệ trái đất thì cái sự sung sướng đó sẽ ở mức nào."
                ,"Marvel"
                ,R.drawable.hd3
                ,""));
        arrPhimHanhDong.add(new Phim("Guardians of the Galaxy"
                ,"Guardians of the Galaxy là bộ phim phong phú về chủng tộc nhất thuộc MCU. Có rất nhiều nhân vật được giới thiệu nhưng ai cũng có cá tính, màu sắc riêng và dễ chiếm được cảm tình từ khán giả. Nhịp phim vừa phải, dễ thở, dễ hiểu nên dù bạn chưa đọc truyện vẫn có thể hiểu phim đang nói cái gì."
                ,"Marvel"
                ,R.drawable.hd4
                ,""));
        arrPhimHanhDong.add(new Phim("Black Panther"
                ,"Guardians of the Galaxy là bộ phim phong phú về chủng tộc nhất thuộc MCU. Có rất nhiều nhân vật được giới thiệu nhưng ai cũng có cá tính, màu sắc riêng và dễ chiếm được cảm tình từ khán giả. Nhịp phim vừa phải, dễ thở, dễ hiểu nên dù bạn chưa đọc truyện vẫn có thể hiểu phim đang nói cái gì."
                ,"Marvel"
                ,R.drawable.hd5
                ,""));

    }
    private void HoatHinh(){
        arrPhimHoatHinh=new ArrayList<>();
        arrPhimHoatHinh.add(new Phim("How to Train Your Dragon"
                ,"Đây là một bộ phim hoạt hình 3D do DreamWorks Animation sản xuất dựa trên câu chuyện cùng tên của Cressida Cowell năm 2003. Câu chuyện diễn ra trong thế giới thần thoại Viking, nơi một thiếu niên Viking trẻ tuổi tên là Hiccup khao khát trở thành một người giết rồng. Tuy nhiên, sau khi bắt được con rồng đầu tiên, Hiccup không những không giết mà kết bạn với chú rồng đáng yêu này."
                ,"khong"
                ,R.drawable.hh1
                ,""));
        arrPhimHoatHinh.add(new Phim("The Incredibles 2"
                ,"The Incredibles là một bộ phim hoạt hình siêu anh hùng hoạt hình hài kịch của Mỹ được đạo diễn bởi Brad Bird, và do Walt Disney Pictures phát hành. Câu chuyện kể về một gia đình các siêu anh hùng sống một cuộc sống yên bình ở ngoại thành, buộc phải che giấu sức mạnh của mình. Cơ hội đến với Robert khi anh nhận được một thông điệp từ một tổ chức bí ẩn, toàn bộ gia đình siêu anh hùng phải hành động để cứu thế giới."
                ,"khong"
                ,R.drawable.hh2
                ,""));
    }
    private void VienTuong(){
        arrPhimVienTuong=new ArrayList<>();
        arrPhimVienTuong.add(new Phim("Ready Player One"
                ,"Ready Player One (tên tiếng Việt: Đấu trường ảo) là bộ phim khoa học viễn tưởng do Steven Spielberg - một trong những người tiên phong của kỉ nguyên điện ảnh New Hollywood (1960-1980) sản xuất và đạo diễn, dựa trên tiểu thuyết cùng tên."
                ,"khong"
                ,R.drawable.vt1
                ,""));
        arrPhimVienTuong.add(new Phim("Annihilation"
                ,"Được Forbes đánh giá cao nhất là bộ phim khoa học viễn tưởng kinh dị Annihilation (Vùng hủy diệt). Bộ phim của đạo diễn tài năng Alex Garland, dựa trên tiểu thuyết cùng tên của Jeff VanderMeer, xoay quanh câu chuyện một đội thám hiểm do nhà sinh vật học Lena (Natalie Portman) dẫn đầu đi vào \"The Shimmer\" (vùng lóng lánh) - một vùng kiểm dịch bí ẩn với nhiều sinh vật quái lạ."
                ,"khong"
                ,R.drawable.vt2
                ,""));
    }
    private void KinhDi(){
        arrPhimKinhDi=new ArrayList<>();
        arrPhimKinhDi.add(new Phim("Drag Me to Hell (2009)"
                ,"Đạo diễn Sam Raimi (bộ ba phim Spider-Man) đã dàn dựng một bản giao hưởng đầy phấn khích về nỗi sợ. Drag Me to Hell kể về nữ nhân viên ngân hàng trẻ và ngây thơ (Alison Lohman đóng). Vì không cho một bà già chột mắt già yếu (Loran Raver) vay tiền, cô bị bà ta nguyền rủa và phải đối mặt với những chuyện kinh hoàng. Sau 3 ngày bị tra tấn, cô gái trẻ bị đẩy xuống địa ngục để bị hỏa thiêu vĩnh viễn."
                ,"khong"
                ,R.drawable.kd1
                ,""));
    }

}

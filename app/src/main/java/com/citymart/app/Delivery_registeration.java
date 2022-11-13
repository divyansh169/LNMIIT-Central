package com.citymart.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.citymart.app.ReusableCode.ReusableCodeForAll;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.ArrayList;
import java.util.HashMap;

public class Delivery_registeration extends AppCompatActivity {

    String[] AndhraPradesh={"Visakhapatnam", "Vijayawada", "Guntur", "Nellore", "Kurnool", "Kakinada", "Rajahmundry", "Kadapa", "Tirupati", "Anantapuram", "Vizianagaram", "Eluru", "Nandyal", "Ongole", "Adoni", "Madanapalle", "Machilipatnam", "Tenali", "Proddatur", "Chittoor", "Hindupur", "Srikakulam", "Bhimavaram", "Tadepalligudem", "Guntakal", "Dharmavaram", "Gudivada", "Narasaraopet", "Kadiri", "Tadipatri", "Mangalagin", "Chilakaluripet"};
    String[] ArunachalPradesh={"ChanglangDistrict", "DibangValleyDistrict", "EastKamengDistrict", "EastSiangDistrict", "KurungKumeyDistrict", "LohitDistrict", "LowerDibangValleyDistrict", "LowerSubansiriDistrict", "PapumPareDistrict", "TawangDistrict", "TirapDistrict", "UpperSiangDistrict", "UpperSubansiriDistrict", "WestKamengDistrict", "WestSiangDistrict"};
    String[] Assam={"Guwahat", "Silchar", "Dibrugarh", "Jorhat", "Nagaon", "Bongaigaon", "Tinsukia", "Tezpur", "Diphu", "Dhubri", "NorthLakhimpur" ,"Karimganj", "Sivasagar", "Goalpara", "BarpetaTown", "Golaghat", "Hafiong", "Mangaldai", "Tangla", "Lanka", "Hojai", "BarpetaRoad", "Kokrajhar", "Hailakandi", "Morigaon", "Nalbari", "Rangia", "Silapathar", "Dhekiajuli", "Dergaon", "Sonari", "Kharupetia", "Nazira", "Lakhipur"};
    String[] Bihar={"Patna", "Gaya", "Bhagalpur", "Purnia", "Muzafaffarpur", "Darbhanga", "BiharShaif", "Arrah", "Begusald", "Katihar", "Munger", "Chhapra", "Danapur", "Bettian", "saharsa", "Hajipur", "Sasaram" ,"Dehri", "Siwan", "Motihar", "Nawada", "Bagand", "Buxar", "Kishanganj", "Sitamarhi", "Jamalpur", "Jehanabad", "Aurangabadd"};
    String[] Chandigarh={"Chandigarhh"};
    String[] Chattisgarh={"NayaRaipur", "Raipur", "Bhilai", "Bilaaspur", "Korba", "Rajnandgaon" ,"Raiigarh", "Ambikapur", "Jagdalpur" ,"Chirmiri", "Dhamtari", "Mahasamund"};
    String[] DadraandNagarHaveli={"DadraandNagarHavelii"};
    String[] DamanandDiu={"DamanandDiuu"};
    String[] Delhi={"Delhii"};
    String[] Goa={"Bicholim" ,"Canacona" ,"Cuncolim" ,"Curchorem", "Mapusa" ,"Margao", "Mormugao", "Panaji" ,"Pernem", "Ponda", "Quepem", "Sanguem", "Sanquelim", "Valpoi"};
    String[] Gujarat={"Amdavad", "Surat", "Vadodara" ,"Rajkot" ,"Bhavnagar", "Jamnagar", "Gandhinagar" ,"Junagadh", "Gandhidham", "Anand", "Navsari" ,"Morbi", "Nadiad", "Surendranagar", "Bharuch", "Mehsana" ,"Bhuj", "Porbandar","Palanpur", "Valsad","Vapi","Gondal" ,"Veraval" ,"Godhra" ,"Patan" ,"Kalol" ,"Dahod", "Botad", "Amreli", "Deesa", "Jetpur"};
    String[] Haryana={"Faridabad" ,"Gurugram" ,"Panipat" ,"Ambala" ,"Yamunanagar" ,"Rohtak" ,"Hisar" ,"Karnal" ,"Sonipat" ,"Panchkula" ,"Bhiwani", "Sirsa", "Bahadurgarn" ,"Jind", "Thanesar" ,"Kaithal" ,"Rewari" ,"Narnaul" ,"Pundri", "Kosli", "Palwal"};
    String[] HimachalPradesh={"Shimla", "Dharamsala", "Solan", "Mandi", "Palampur", "Baddi", "Nahan", "PaontaSahib", "Sundanagar", "Chamba", "Una", "Kullu" ,"Hamirpur", "Bilaspur", "YolCantonment", "Nalagarh", "Nurpur", "Kangra", "Santokhgarh", "MehatpurBasdehra" ,"Shamshi", "Parwanoo", "Manali", "TiraSujanpur", "Ghumarwin", "Dalhousie", "Rohru", "NagrotaBagwan", "Raampur", "Jawalamukhi", "Jogindernagar", "DeraGopipur", "Sarkaghat", "Jhakhri", "Indora", "Bhuntar", "Nadaun", "Theog", "KasauliCantonment", "Gagret", "ChuariKhas", "Daulatpur", "SabathuCantonment", "DalhousieCantonment", "Raigarh", "Arki", "DagshaiCantonment", "Seoni", "Talai", "JutoghCantonment", "Chaupal", "Rewalsar", "BaklohCantonment", "Jubbal", "Bhota", "Banjar", "NainaDevi", "Kotkhai", "Narkanda"};
    String[] JammuandKashmir={"Srinagar", "Jammu", "Anantnag"};
    String[] Jharkhand={"Jamshedpur" ,"Dhanbad", "Ranchi", "BokaroSteelCity", "Deoghar" ,"Phusro" ,"Hazaribagh", "Giridih", "Ramgarh", "Medininagar", "Chirkunda"};
    String[] Karnataka={"Bangalore", "HubliDharwad", "Mysore", "Gulbarga", "Mangalore", "Belgaum", "Davanagere", "Bellary", "Bijapur", "Shimoga", "Tumkur", "Raichur" ,"Bidar" ,"Hospet" ,"GadagBetageri" ,"Robertsonpet" ,"Hassan" ,"Bhadravati" ,"Chitradurga", "Udupi", "Kolar", "Mandya", "Chikmagalur", "Gangavati", "Bagalkot", "Ranebennuru"};
    String[] Kerala={"Thiruvananthapuram","Kozhikode","Kochi","Kollam","Thrissur","Kannur","Alappuzha","Kottayam","Palakkad","Manjeri","Thalassery","Ponnani","Vatakara","Kanhangad","Payyanur","Koyilandy","Parappanangadi","Kalamassery","Neyyattinkara","Tanur","Thrippunithura","Kayamkulam","Malappuram","Thrikkakkara","Wadakkancherry","Nedumangad","Kondotty","Tirurangad","irur","Panoor","Nileshwaram","Kasaragod","Feroke","KunnamkUlam","Ottappalam","Tiruvalla","Thodupuzha","Perinthalmanna","Chalakudy","Payyoll","Koduvally","Mananthavady","Changanassery","Mattanur","Punalur","Nilambur","Cherthala","SultanBathery","Maradu","Kottakkal","Taliparamba","Shornur","ndalam","Kattappana","Mukkam","ty","chery","Varkala","Cherpulassery","Chavakkad","Kothamangalam","Pathanamthitta","Atingal","aravur","Ramanattukara","Mannarkkad","rattupetta","Kodungallur","Sreekandapuram","Anganiauy","Chittur","Thathamangalam","Kalpetta","NorthParavur","Haripad","Muvattupuzha","Kottarakara","Kuthuparamba","Adoor","Piravom","Irinjalakuda","Pattambi","Anthoor","Perumbavoor","Ettumanoor","Mavelikkara","Karunagappalli","Eloor","Chengannur","Vaikom","Aluva","Pala","Guruvayur","Koothattukulam","Avinissery"};
    String[] Ladakh={"Ladakhh"};
    String[] MadhyaPradesh={"Indore","Bhopal","Jabalpur","Gwalior","Katni","Ujjain","Dewas","Satna","Ratlam","Rewa","Sagar","Singrauli","Burhanpur","Khandwa","Bhind","Chhindwara","Guna","Shivpuri","Vidisha","Chhatarpur","Damoh","Mandsaur","Khargone","Neemuch","Pithampur","Narmadapuram","Itarsi","Sehore","Morena","Betul","Seonii","Datia","Nagda","Dindori"};
    String[] Maharashtra = {"Mumbai","Pune","Nagpur","Thane","PCMCPune","Nashik","KalyanDombivli","VasaiVirarCityMC","Aurangabad","NaviMumbai","Solapur","MiraBhayandar","BhiwandiNizampurMC","Jalgaon","Amravati","Nanded","Kolhapur","Ulhasnagar","SangliMirajKupwad","Malegaon","Akola","Latur","Dhule","Ahmednagar","Chandrapur","Parbhani","Ichalkaranji","Jalna","Ambarnath","Bhusawal","Panvel","Badlapur","Beed","Gondia","Satara","Barshi","Yavatmal","Achalpur","Osmanabad","Nandurbar","Wardha","Udgir","Hinganghat"};
    String[] Manipur={"Bishnupur","Thoubal","ImphalEast","ImphalWest","Senapati","Ukhrul","Chandel","Churachandpur","Tamenglong","Jiribam","Kangpokpi","Kakching","Tengnoupal","Kamjong","Noney","Pherzawi"};
    String[] Meghalaya={"Meghalayaa"};
    String[] Mizoram={"Aizawl","Kolasib","Lawngtlai","Lunglei","Mamit","Saiha","Serchhip","Champhai","Hnahthial","Khawzawl","Saitual"};
    String[] Nagaland={"Dimapur","Kiphire","Kohima","Longleng","Mokokchung","Mon","Peren","Phek","Tuensang","Wokha","Zunhebote"};
    String[] Odisha={"Bhubaneswar","Cuttack","Rourkela","Berhampur","Sambalpur","Puri","Balasore","Bhadrak","Baripada"};
    String[] Puducherry={"Puducherryy"};
    String[] Punjab={"Ludhiana", "Amritsar", "Jalandhar", "Patiala", "Bathinda", "Mohali", "Firozpur", "Batala", "Pathankot", "Moga", "Abohar", "Malerkotla", "Khanna", "Phagwara", "Muktsar", "Barnala", "Rajpura", "Hoshiarpur", "Kapurthala", "Faridkot", "Sunam"};
    String[] Rajasthan={"Jaipur","Jodhpur","Kota ","Bhiwadi","Bikaner","Udaipur","Ajmer","Bhilwara","Alwar","Sikar","Bharatpur","Pali","SriGanganagar","Kishangarh","Baran","Dhaulpur","Tonk","Beawar","Hanumangarh"};
    String[] Sikkim={"Gangtok","Mangan","Namchi","Gyalshing","Pakyong","Soreng"};
    String[] TamilNadu={"Chennai","Coimbatore","Madural","Tiruchirappalli","Salem","Tirunelveli","Tiruppur","Vellore","Erode","Thoothukkudi","Dindigul","Thanjavur","Ranipet","Sivakasi","Karur","Udhagamandalam","Hosur","Nagercoil","Kanchipuram","Kumarapalayam","Karaikkudi","Neyveli","Cuddalore","Kumbakonam","Tiruvannamalai","Pollachi","Rajapalayam","Gudiyatham","Pudukkottai","Vaniyambadi","Ambur","Nagapattinam"};
    String[] Telangana={"Hyderabad","Warangala","Nizamabad","Khammam","Karimnagar","Ramagundam","Mahabubnagar","Nalgonda","Adilabad","Suryapet ","Siddipet","Miryalaguda","Jagtial","Mancherial","Nimal","Sircilla","Kamareddy","Palwancha","Kothagudem","Bodhan","Sangareddy","Metpally","Zahirabad","MeerpetJillelguda","Korutla","Tandur","Badangpet","Kodad","Armur","Gadwal","Wanaparthy","Kagaznagar","Bellampalle","KhanapuramHaveli","Bhuvanagiri","Vikarabad","Jangaon","Mandamam","Peerzadiguda","Bhadrachalam","Bhainsa","Boduppal","Jawaharnagar","Medak","Shamshabad","Mahabubabad","Bhupalpally","Narayanpet","Peddapaill","Dundigal","Huzumagar","Medchal","BandlagudaJagir","Kyathanpally","Manuguru","Naspur","Narsampet","Devarakonda","Dubbaka","Nakrekal","Banswada","Kalwakurthy","NagarKurnool","Parigi","Thumkunta","Neredcherla","Nagaram","Gajwel","Chennur","Asifabad","Madhira","Ghatkesar","Kompally","Dasnapur","Sarapaka","Husnabad","Pocharam","Dammaiguda","Achampet"};
    String[] Tripura={"Agartala","Dharmanagar","Udaipurr","Kailashahar","Bishalgarh","Teliamura","Khowai","Belonia","Melaghar","Mohanpur","Ambassa","Ranirbazar","Santirbazar","Kumarghat","Sonamura","Panisagar","Amarpur","Jirania","Kamalpur","Sabroom"};
    String[] UttarPradesh = {"Mathura", "Agra", "Aligarh", "Kanpur", "Lucknow", "Ghaziabad", "Meerut", "Varanasi", "Prayagraj", "Bareilly", "Moradabad", "Saharanpur", "Gorakhpur", "Noida", "Firozabad", "Jhansi", "Muzaffarnagar", "Goverdhan", "Vrindavan", "Budaun", "Rampur", "Shahjahanpur", "FarrukhabadcumFategarh", "FaizabadandAyodhya", "MaunathBhanjan", "Hapur", "Ayodhya", "Etawah", "MirzapurcumVindhyachal", "Bulandshahr", "Sambhal", "Amroha", "Hardoi", "Fatehpur", "Raebareli", "Orai", "Sitapur", "Bahraich", "Modinagar", "Unnao", "Jaunpur", "Lakhimpur","Hathras", "Banda", "Pilibhit", "Barabanki", "Khurja", "Gonda", "Mainpuri", "Lalitpur", "Etah", "Deoria", "Ujhani", "Ghazipur", "Sultanpur", "Azamgarh", "Bijnor", "Sahaswan", "Basti", "Chandausi", "Akbarpur", "Ballia", "Tanda", "GreaterNoida", "Shikohabad", "Shamli", "Awagarh", "Kasganj"};
    String[] Uttarakhand={"Dehradun","Haridwar","Roorkee","HaldwanicumKathgodamNainital","Rudrapur","Kashipur","Rishikesh"};
    String[] WestBengal={"Kolkata","Asansol","Siliguri","Durgapur","Bardhaman","Malda","Baharampur","Habra","Kharagpur","Shantipur","Dankuni","Dhulian","Ranaghat","Haldia","Raiganj","Krishnanagar","Nabadwip","Medinipur","Jalpaiguri","Balurghat","Basirhat","Bankura","Chakdaha","Darjeeling","Alipurduar","Purulia","Jangipur","Bolpur","Bangaon","CoochBehar"};




    String[] Mumbai = {"Churchgate", "Marine Lines", "Charni Road", "Grant Road", "Mumbai Central", "Mahalakshmi", "Lower Parel", "Prabhadevi",
            "Dadar", "Matunga", "Mahim", "Bandra", "Khar", "Santacruz", "Vile Parle", "Andheri", "Jogeshwari", "Ram Mandir",
            "Goregaon", "Malad", "Kandivai", "Borivali", "Dahisar", "MiraRoad", "Bhayander", "Naigaon", "Vasai Road", "Nalla Sopara", "Virar"};
    String[] Pune = {"Hinjewadi", "Wagholi", " Ambegaon", "Undri", "Katraj"};
    String[] Aurangabad = {"Aarif Colony", "Baiji Pura", "Balaji Nagar", "Angoori Bagh"};
    String[] Mathura={"Khandelwal Mega Mart", "VLN Whole Sale", "Mast Banarasi Paan"};
    String[] Aligarh={"Agnovad","Akoti","Amroli","Athwalines"};
    String[] Agra={"Kalawad Road","Astron chowk","Kotecha chowk","Trikon bag"};
    String[] Visakhapatnam={"Visakhapatnam"};
    String[] Vijayawada={"Vijayawada"};
    String[] Guntur={"Guntur"};
    String[] Nellore={"Nellore"};
    String[] Kurnool={"Kurnool"};
    String[] Kakinada={"Kakinada"};
    String[] Rajahmundry={"Rajahmundry"};
    String[] Kadapa={"Kadapa"};
    String[] Tirupati={"Tirupati"};
    String[] Anantapuram={"Anantapuram"};
    String[] Vizianagaram={"Vizianagaram"};
    String[] Eluru={"Eluru"};
    String[] Nandyal={"Nandyal"};
    String[] Ongole={"Ongole"};
    String[] Adoni={"Adoni"};
    String[] Madanapalle={"Madanapalle"};
    String[] Machilipatnam={"Machilipatnam"};
    String[] Tenali={"Tenali"};
    String[] Proddatur={"Proddatur"};
    String[] Chittoor={"Chittoor"};
    String[] Hindupur={"Hindupur"};
    String[] Srikakulam={"Srikakulam"};
    String[] Bhimavaram={"Bhimavaram"};
    String[] Tadepalligudem={"Tadepalligudem"};
    String[] Guntakal={"Guntakal"};
    String[] Dharmavaram={"Dharmavaram"};
    String[] Gudivada={"Gudivada"};
    String[] Narasaraopet={"Narasaraopet"};
    String[] Kadiri={"Kadiri"};
    String[] Tadipatri={"Tadipatri"};
    String[] Mangalagin={"Mangalagin"};
    String[] Chilakaluripet={"Chilakaluripet"};
    String[] ChanglangDistrict={"ChanglangDistrict"};
    String[] DibangValleyDistrict={"DibangValleyDistrict"};
    String[] EastKamengDistrict={"EastKamengDistrict"};
    String[] EastSiangDistrict={"EastSiangDistrict"};
    String[] KurungKumeyDistrict={"KurungKumeyDistrict"};
    String[] LohitDistrict={"LohitDistrict"};
    String[] LowerDibangValleyDistrict={"LowerDibangValleyDistrict"};
    String[] LowerSubansiriDistrict={"LowerSubansiriDistrict"};
    String[] PapumPareDistrict={"PapumPareDistrict"};
    String[] TawangDistrict={"TawangDistrict"};
    String[] TirapDistrict={"TirapDistrict"};
    String[] UpperSiangDistrict={"UpperSiangDistrict"};
    String[] UpperSubansiriDistrict={"UpperSubansiriDistrict"};
    String[] WestKamengDistrict={"WestKamengDistrict"};
    String[] WestSiangDistrict={"WestSiangDistrict"};
    String[] Guwahat={"Guwahat"};
    String[] Silchar={"Silchar"};
    String[] Dibrugarh={"Dibrugarh"};
    String[] Jorhat={"Jorhat"};
    String[] Nagaon={"Nagaon"};
    String[] Bongaigaon={"Bongaigaon"};
    String[] Tinsukia={"Tinsukia"};
    String[] Tezpur={"Tezpur"};
    String[] Diphu={"Diphu"};
    String[] Dhubri={"Dhubri"};
    String[] NorthLakhimpur={"NorthLakhimpur"};
    String[] Karimganj={"Karimganj"};
    String[] Sivasagar={"Sivasagar"};
    String[] Goalpara={"Goalpara"};
    String[] BarpetaTown={"BarpetaTown"};
    String[] Golaghat={"Golaghat"};
    String[] Hafiong={"Hafiong"};
    String[] Mangaldai={"Mangaldai"};
    String[] Tangla={"Tangla"};
    String[] Lanka={"Lanka"};
    String[] Hojai={"Hojai"};
    String[] BarpetaRoad={"BarpetaRoad"};
    String[] Kokrajhar={"Kokrajhar"};
    String[] Hailakandi={"Hailakandi"};
    String[] Morigaon={"Morigaon"};
    String[] Nalbari={"Nalbari"};
    String[] Rangia={"Rangia"};
    String[] Silapathar={"Silapathar"};
    String[] Dhekiajuli={"Dhekiajuli"};
    String[] Dergaon={"Dergaon"};
    String[] Sonari={"Sonari"};
    String[] Kharupetia={"Kharupetia"};
    String[] Nazira={"Nazira"};
    String[] Lakhipur={"Lakhipur"};
    String[] Patna={"Patna"};
    String[] Gaya={"Gaya"};
    String[] Bhagalpur={"Bhagalpur"};
    String[] Purnia={"Purnia"};
    String[] Muzafaffarpur={"Muzafaffarpur"};
    String[] Darbhanga={"Darbhanga"};
    String[] BiharShaif={"BiharShaif"};
    String[] Arrah={"Arrah"};
    String[] Begusald={"Begusald"};
    String[] Katihar={"Katihar"};
    String[] Munger={"Munger"};
    String[] Chhapra={"Chhapra"};
    String[] Danapur={"Danapur"};
    String[] Bettian={"Bettian"};
    String[] saharsa={"saharsa"};
    String[] Hajipur={"Hajipur"};
    String[] Sasaram={"Sasaram"};
    String[] Dehri={"Dehri"};
    String[] Siwan={"Siwan"};
    String[] Motihar={"Motihar"};
    String[] Nawada={"Nawada"};
    String[] Bagand={"Bagand"};
    String[] Buxar={"Buxar"};
    String[] Kishanganj={"Kishanganj"};
    String[] Sitamarhi={"Sitamarhi"};
    String[] Jamalpur={"Jamalpur"};
    String[] Jehanabad={"Jehanabad"};
    String[] Chandigarhh={"Chandigarh"};
    String[] NayaRaipur={"NayaRaipur"};
    String[] Raipur={"Raipur"};
    String[] Bhilai={"Bhilai"};
    String[] Bilaspur={"Bilaspur"};
    String[] Korba={"Korba"};
    String[] Rajnandgaon={"Rajnandgaon"};
    String[] Raigarh={"Raigarh"};
    String[] Ambikapur={"Ambikapur"};
    String[] Jagdalpur={"Jagdalpur"};
    String[] Chirmiri={"Chirmiri"};
    String[] Dhamtari={"Dhamtari"};
    String[] Mahasamund={"Mahasamund"};
    String[] DadraandNagarHavelii={"DadraandNagarHaveli"};
    String[] DamanandDiuu={"DamanandDiu"};
    String[] Delhii={"Delhi"};
    String[] Bicholim={"Bicholim"};
    String[] Canacona={"Canacona"};
    String[] Cuncolim={"Cuncolim"};
    String[] Curchorem={"Curchorem"};
    String[] Mapusa={"Mapusa"};
    String[] Margao={"Margao"};
    String[] Mormugao={"Mormugao"};
    String[] Panaji={"Panaji"};
    String[] Pernem={"Pernem"};
    String[] Ponda={"Ponda"};
    String[] Quepem={"Quepem"};
    String[] Sanguem={"Sanguem"};
    String[] Sanquelim={"Sanquelim"};
    String[] Valpoi={"Valpoi"};
    String[] Amdavad={"Amdavad"};
    String[] Surat={"Surat"};
    String[] Vadodara={"Vadodara"};
    String[] Rajkot={"Rajkot"};
    String[] Bhavnagar={"Bhavnagar"};
    String[] Jamnagar={"Jamnagar"};
    String[] Gandhinagar={"Gandhinagar"};
    String[] Junagadh={"Junagadh"};
    String[] Gandhidham={"Gandhidham"};
    String[] Anand={"Anand"};
    String[] Navsari={"Navsari"};
    String[] Morbi={"Morbi"};
    String[] Nadiad={"Nadiad"};
    String[] Surendranagar={"Surendranagar"};
    String[] Bharuch={"Bharuch"};
    String[] Mehsana={"Mehsana"};
    String[] Bhuj={"Bhuj"};
    String[] Porbandar={"Porbandar"};
    String[] Palanpur={"Palanpur"};
    String[] Valsad={"Valsad"};
    String[] Vapi={"Vapi"};
    String[] Gondal={"Gondal"};
    String[] Veraval={"Veraval"};
    String[] Godhra={"Godhra"};
    String[] Patan={"Patan"};
    String[] Kalol={"Kalol"};
    String[] Dahod={"Dahod"};
    String[] Botad={"Botad"};
    String[] Amreli={"Amreli"};
    String[] Deesa={"Deesa"};
    String[] Jetpur={"Jetpur"};
    String[] Faridabad={"Faridabad"};
    String[] Gurugram={"Gurugram"};
    String[] Panipat={"Panipat"};
    String[] Ambala={"Ambala"};
    String[] Yamunanagar={"Yamunanagar"};
    String[] Rohtak={"Rohtak"};
    String[] Hisar={"Hisar"};
    String[] Karnal={"Karnal"};
    String[] Sonipat={"Sonipat"};
    String[] Panchkula={"Panchkula"};
    String[] Bhiwani={"Bhiwani"};
    String[] Sirsa={"Sirsa"};
    String[] Bahadurgarn={"Bahadurgarn"};
    String[] Jind={"Jind"};
    String[] Thanesar={"Thanesar"};
    String[] Kaithal={"Kaithal"};
    String[] Rewari={"Rewari"};
    String[] Narnaul={"Narnaul"};
    String[] Pundri={"Pundri"};
    String[] Kosli={"Kosli"};
    String[] Palwal={"Palwal"};
    String[] Shimla={"Shimla"};
    String[] Dharamsala={"Dharamsala"};
    String[] Solan={"Solan"};
    String[] Mandi={"Mandi"};
    String[] Palampur={"Palampur"};
    String[] Baddi={"Baddi"};
    String[] Nahan={"Nahan"};
    String[] PaontaSahib={"PaontaSahib"};
    String[] Sundanagar={"Sundanagar"};
    String[] Chamba={"Chamba"};
    String[] Una={"Una"};
    String[] Kullu={"Kullu"};
    String[] Hamirpur={"Hamirpur"};
    String[] Bilaaspur={"Bilaspur"};
    String[] YolCantonment={"YolCantonment"};
    String[] Nalagarh={"Nalagarh"};
    String[] Nurpur={"Nurpur"};
    String[] Kangra={"Kangra"};
    String[] Santokhgarh={"Santokhgarh"};
    String[] MehatpurBasdehra={"MehatpurBasdehra"};
    String[] Shamshi={"Shamshi"};
    String[] Parwanoo={"Parwanoo"};
    String[] Manali={"Manali"};
    String[] TiraSujanpur={"TiraSujanpur"};
    String[] Ghumarwin={"Ghumarwin"};
    String[] Dalhousie={"Dalhousie"};
    String[] Rohru={"Rohru"};
    String[] NagrotaBagwan={"NagrotaBagwan"};
    String[] Rampur={"Rampur"};
    String[] Jawalamukhi={"Jawalamukhi"};
    String[] Jogindernagar={"Jogindernagar"};
    String[] DeraGopipur={"DeraGopipur"};
    String[] Sarkaghat={"Sarkaghat"};
    String[] Jhakhri={"Jhakhri"};
    String[] Indora={"Indora"};
    String[] Bhuntar={"Bhuntar"};
    String[] Nadaun={"Nadaun"};
    String[] Theog={"Theog"};
    String[] KasauliCantonment={"KasauliCantonment"};
    String[] Gagret={"Gagret"};
    String[] ChuariKhas={"ChuariKhas"};
    String[] Daulatpur={"Daulatpur"};
    String[] SabathuCantonment={"SabathuCantonment"};
    String[] DalhousieCantonment={"DalhousieCantonment"};
    String[] Raiigarh={"Raigarh"};
    String[] Arki={"Arki"};
    String[] DagshaiCantonment={"DagshaiCantonment"};
    String[] Seoni={"Seoni"};
    String[] Talai={"Talai"};
    String[] JutoghCantonment={"JutoghCantonment"};
    String[] Chaupal={"Chaupal"};
    String[] Rewalsar={"Rewalsar"};
    String[] BaklohCantonment={"BaklohCantonment"};
    String[] Jubbal={"Jubbal"};
    String[] Bhota={"Bhota"};
    String[] Banjar={"Banjar"};
    String[] NainaDevi={"NainaDevi"};
    String[] Kotkhai={"Kotkhai"};
    String[] Narkanda={"Narkanda"};
    String[] Srinagar={"Srinagar"};
    String[] Jammu={"Jammu"};
    String[] Anantnag={"Anantnag"};
    String[] Jamshedpur={"Jamshedpur"};
    String[] Dhanbad={"Dhanbad"};
    String[] Ranchi={"Ranchi"};
    String[] BokaroSteelCity={"BokaroSteelCity"};
    String[] Deoghar={"Deoghar"};
    String[] Phusro={"Phusro"};
    String[] Hazaribagh={"Hazaribagh"};
    String[] Giridih={"Giridih"};
    String[] Ramgarh={"Ramgarh"};
    String[] Medininagar={"Medininagar"};
    String[] Chirkunda={"Chirkunda"};
    String[] Bangalore={"Bangalore"};
    String[] HubliDharwad={"HubliDharwad"};
    String[] Mysore={"Mysore"};
    String[] Gulbarga={"Gulbarga"};
    String[] Mangalore={"Mangalore"};
    String[] Belgaum={"Belgaum"};
    String[] Davanagere={"Davanagere"};
    String[] Bellary={"Bellary"};
    String[] Bijapur={"Bijapur"};
    String[] Shimoga={"Shimoga"};
    String[] Tumkur={"Tumkur"};
    String[] Raichur={"Raichur"};
    String[] Bidar={"Bidar"};
    String[] Hospet={"Hospet"};
    String[] GadagBetageri={"GadagBetageri"};
    String[] Robertsonpet={"Robertsonpet"};
    String[] Hassan={"Hassan"};
    String[] Bhadravati={"Bhadravati"};
    String[] Chitradurga={"Chitradurga"};
    String[] Udupi={"Udupi"};
    String[] Kolar={"Kolar"};
    String[] Mandya={"Mandya"};
    String[] Chikmagalur={"Chikmagalur"};
    String[] Gangavati={"Gangavati"};
    String[] Bagalkot={"Bagalkot"};
    String[] Ranebennuru={"Ranebennuru"};
    String[] Thiruvananthapuram={"Thiruvananthapuram"};
    String[] Kozhikode={"Kozhikode"};
    String[] Kochi={"Kochi"};
    String[] Kollam={"Kollam"};
    String[] Thrissur={"Thrissur"};
    String[] Kannur={"Kannur"};
    String[] Alappuzha={"Alappuzha"};
    String[] Kottayam={"Kottayam"};
    String[] Palakkad={"Palakkad"};
    String[] Manjeri={"Manjeri"};
    String[] Thalassery={"Thalassery"};
    String[] Ponnani={"Ponnani"};
    String[] Vatakara={"Vatakara"};
    String[] Kanhangad={"Kanhangad"};
    String[] Payyanur={"Payyanur"};
    String[] Koyilandy={"Koyilandy"};
    String[] Parappanangadi={"Parappanangadi"};
    String[] Kalamassery={"Kalamassery"};
    String[] Neyyattinkara={"Neyyattinkara"};
    String[] Tanur={"Tanur"};
    String[] Thrippunithura={"Thrippunithura"};
    String[] Kayamkulam={"Kayamkulam"};
    String[] Malappuram={"Malappuram"};
    String[] Thrikkakkara={"Thrikkakkara"};
    String[] Wadakkancherry={"Wadakkancherry"};
    String[] Nedumangad={"Nedumangad"};
    String[] Kondotty={"Kondotty"};
    String[] Tirurangad={"Tirurangad"};
    String[] irur={"irur"};
    String[] Panoor={"Panoor"};
    String[] Nileshwaram={"Nileshwaram"};
    String[] Kasaragod={"Kasaragod"};
    String[] Feroke={"Feroke"};
    String[] KunnamkUlam={"KunnamkUlam"};
    String[] Ottappalam={"Ottappalam"};
    String[] Tiruvalla={"Tiruvalla"};
    String[] Thodupuzha={"Thodupuzha"};
    String[] Perinthalmanna={"Perinthalmanna"};
    String[] Chalakudy={"Chalakudy"};
    String[] Payyoll={"Payyoll"};
    String[] Koduvally={"Koduvally"};
    String[] Mananthavady={"Mananthavady"};
    String[] Changanassery={"Changanassery"};
    String[] Mattanur={"Mattanur"};
    String[] Punalur={"Punalur"};
    String[] Nilambur={"Nilambur"};
    String[] Cherthala={"Cherthala"};
    String[] SultanBathery={"SultanBathery"};
    String[] Maradu={"Maradu"};
    String[] Kottakkal={"Kottakkal"};
    String[] Taliparamba={"Taliparamba"};
    String[] Shornur={"Shornur"};
    String[] ndalam={"ndalam"};
    String[] Kattappana={"Kattappana"};
    String[] Mukkam={"Mukkam"};
    String[] ty={"ty"};
    String[] chery={"chery"};
    String[] Varkala={"Varkala"};
    String[] Cherpulassery={"Cherpulassery"};
    String[] Chavakkad={"Chavakkad"};
    String[] Kothamangalam={"Kothamangalam"};
    String[] Pathanamthitta={"Pathanamthitta"};
    String[] Atingal={"Atingal"};
    String[] aravur={"aravur"};
    String[] Ramanattukara={"Ramanattukara"};
    String[] Mannarkkad={"Mannarkkad"};
    String[] rattupetta={"rattupetta"};
    String[] Kodungallur={"Kodungallur"};
    String[] Sreekandapuram={"Sreekandapuram"};
    String[] Anganiauy={"Anganiauy"};
    String[] Chittur={"Chittur"};
    String[] Thathamangalam={"Thathamangalam"};
    String[] Kalpetta={"Kalpetta"};
    String[] NorthParavur={"NorthParavur"};
    String[] Haripad={"Haripad"};
    String[] Muvattupuzha={"Muvattupuzha"};
    String[] Kottarakara={"Kottarakara"};
    String[] Kuthuparamba={"Kuthuparamba"};
    String[] Adoor={"Adoor"};
    String[] Piravom={"Piravom"};
    String[] Irinjalakuda={"Irinjalakuda"};
    String[] Pattambi={"Pattambi"};
    String[] Anthoor={"Anthoor"};
    String[] Perumbavoor={"Perumbavoor"};
    String[] Ettumanoor={"Ettumanoor"};
    String[] Mavelikkara={"Mavelikkara"};
    String[] Karunagappalli={"Karunagappalli"};
    String[] Eloor={"Eloor"};
    String[] Chengannur={"Chengannur"};
    String[] Vaikom={"Vaikom"};
    String[] Aluva={"Aluva"};
    String[] Pala={"Pala"};
    String[] Guruvayur={"Guruvayur"};
    String[] Koothattukulam={"Koothattukulam"};
    String[] Avinissery={"Avinissery"};
    String[] Ladakhh={"Ladakh"};
    String[] Indore={"Indore"};
    String[] Bhopal={"Bhopal"};
    String[] Jabalpur={"Jabalpur"};
    String[] Gwalior={"Gwalior"};
    String[] Katni={"Katni"};
    String[] Ujjain={"Ujjain"};
    String[] Dewas={"Dewas"};
    String[] Satna={"Satna"};
    String[] Ratlam={"Ratlam"};
    String[] Rewa={"Rewa"};
    String[] Sagar={"Sagar"};
    String[] Singrauli={"Singrauli"};
    String[] Burhanpur={"Burhanpur"};
    String[] Khandwa={"Khandwa"};
    String[] Bhind={"Bhind"};
    String[] Chhindwara={"Chhindwara"};
    String[] Guna={"Guna"};
    String[] Shivpuri={"Shivpuri"};
    String[] Vidisha={"Vidisha"};
    String[] Chhatarpur={"Chhatarpur"};
    String[] Damoh={"Damoh"};
    String[] Mandsaur={"Mandsaur"};
    String[] Khargone={"Khargone"};
    String[] Neemuch={"Neemuch"};
    String[] Pithampur={"Pithampur"};
    String[] Narmadapuram={"Narmadapuram"};
    String[] Itarsi={"Itarsi"};
    String[] Sehore={"Sehore"};
    String[] Morena={"Morena"};
    String[] Betul={"Betul"};
    String[] Seonii={"Seoni"};
    String[] Datia={"Datia"};
    String[] Nagda={"Nagda"};
    String[] Dindori={"Dindori"};
    String[] Nagpur={"Nagpur"};
    String[] Thane={"Thane"};
    String[] PCMCPune={"PCMCPune"};
    String[] Nashik={"Nashik"};
    String[] KalyanDombivli={"KalyanDombivli"};
    String[] VasaiVirarCityMC={"VasaiVirarCityMC"};
    String[] Aurangabadd={"Aurangabad"};
    String[] NaviMumbai={"NaviMumbai"};
    String[] Solapur={"Solapur"};
    String[] MiraBhayandar={"MiraBhayandar"};
    String[] BhiwandiNizampurMC={"BhiwandiNizampurMC"};
    String[] Jalgaon={"Jalgaon"};
    String[] Amravati={"Amravati"};
    String[] Nanded={"Nanded"};
    String[] Kolhapur={"Kolhapur"};
    String[] Ulhasnagar={"Ulhasnagar"};
    String[] SangliMirajKupwad={"SangliMirajKupwad"};
    String[] Malegaon={"Malegaon"};
    String[] Akola={"Akola"};
    String[] Latur={"Latur"};
    String[] Dhule={"Dhule"};
    String[] Ahmednagar={"Ahmednagar"};
    String[] Chandrapur={"Chandrapur"};
    String[] Parbhani={"Parbhani"};
    String[] Ichalkaranji={"Ichalkaranji"};
    String[] Jalna={"Jalna"};
    String[] Ambarnath={"Ambarnath"};
    String[] Bhusawal={"Bhusawal"};
    String[] Panvel={"Panvel"};
    String[] Badlapur={"Badlapur"};
    String[] Beed={"Beed"};
    String[] Gondia={"Gondia"};
    String[] Satara={"Satara"};
    String[] Barshi={"Barshi"};
    String[] Yavatmal={"Yavatmal"};
    String[] Achalpur={"Achalpur"};
    String[] Osmanabad={"Osmanabad"};
    String[] Nandurbar={"Nandurbar"};
    String[] Wardha={"Wardha"};
    String[] Udgir={"Udgir"};
    String[] Hinganghat={"Hinganghat"};
    String[] Bishnupur={"Bishnupur"};
    String[] Thoubal={"Thoubal"};
    String[] ImphalEast={"ImphalEast"};
    String[] ImphalWest={"ImphalWest"};
    String[] Senapati={"Senapati"};
    String[] Ukhrul={"Ukhrul"};
    String[] Chandel={"Chandel"};
    String[] Churachandpur={"Churachandpur"};
    String[] Tamenglong={"Tamenglong"};
    String[] Jiribam={"Jiribam"};
    String[] Kangpokpi={"Kangpokpi"};
    String[] Kakching={"Kakching"};
    String[] Tengnoupal={"Tengnoupal"};
    String[] Kamjong={"Kamjong"};
    String[] Noney={"Noney"};
    String[] Pherzawi={"Pherzawi"};
    String[] Meghalayaa={"Meghalaya"};
    String[] Aizawl={"Aizawl"};
    String[] Kolasib={"Kolasib"};
    String[] Lawngtlai={"Lawngtlai"};
    String[] Lunglei={"Lunglei"};
    String[] Mamit={"Mamit"};
    String[] Saiha={"Saiha"};
    String[] Serchhip={"Serchhip"};
    String[] Champhai={"Champhai"};
    String[] Hnahthial={"Hnahthial"};
    String[] Khawzawl={"Khawzawl"};
    String[] Saitual={"Saitual"};
    String[] Dimapur={"Dimapur"};
    String[] Kiphire={"Kiphire"};
    String[] Kohima={"Kohima"};
    String[] Longleng={"Longleng"};
    String[] Mokokchung={"Mokokchung"};
    String[] Mon={"Mon"};
    String[] Peren={"Peren"};
    String[] Phek={"Phek"};
    String[] Tuensang={"Tuensang"};
    String[] Wokha={"Wokha"};
    String[] Zunhebote={"Zunhebote"};
    String[] Bhubaneswar={"Bhubaneswar"};
    String[] Cuttack={"Cuttack"};
    String[] Rourkela={"Rourkela"};
    String[] Berhampur={"Berhampur"};
    String[] Sambalpur={"Sambalpur"};
    String[] Puri={"Puri"};
    String[] Balasore={"Balasore"};
    String[] Bhadrak={"Bhadrak"};
    String[] Baripada={"Baripada"};
    String[] Puducherryy={"Puducherry"};
    String[] Ludhiana={"Ludhiana"};
    String[] Amritsar={"Amritsar"};
    String[] Jalandhar={"Jalandhar"};
    String[] Patiala={"Patiala"};
    String[] Bathinda={"Bathinda"};
    String[] Mohali={"Mohali"};
    String[] Firozpur={"Firozpur"};
    String[] Batala={"Batala"};
    String[] Pathankot={"Pathankot"};
    String[] Moga={"Moga"};
    String[] Abohar={"Abohar"};
    String[] Malerkotla={"Malerkotla"};
    String[] Khanna={"Khanna"};
    String[] Phagwara={"Phagwara"};
    String[] Muktsar={"Muktsar"};
    String[] Barnala={"Barnala"};
    String[] Rajpura={"Rajpura"};
    String[] Hoshiarpur={"Hoshiarpur"};
    String[] Kapurthala={"Kapurthala"};
    String[] Faridkot={"Faridkot"};
    String[] Sunam={"Sunam"};
    String[] Jaipur={"TFB", "Bazzinga",  "Akad-Bakad", "BABA Juice", "Samose-Wala", "Amul-Parlour"};
    String[] Jodhpur={"Jodhpur"};
    String[] Kota ={"Kota "};
    String[] Bhiwadi={"Bhiwadi"};
    String[] Bikaner={"Bikaner"};
    String[] Udaipur={"Udaipur"};
    String[] Ajmer={"Ajmer"};
    String[] Bhilwara={"Bhilwara"};
    String[] Alwar={"Alwar"};
    String[] Sikar={"Sikar"};
    String[] Bharatpur={"Ravi Tiffin Center (Yash Meena)"};
    String[] Pali={"Pali"};
    String[] SriGanganagar={"SriGanganagar"};
    String[] Kishangarh={"Kishangarh"};
    String[] Baran={"Baran"};
    String[] Dhaulpur={"Dhaulpur"};
    String[] Tonk={"Tonk"};
    String[] Beawar={"Beawar"};
    String[] Hanumangarh={"Hanumangarh"};
    String[] Gangtok={"Gangtok"};
    String[] Mangan={"Mangan"};
    String[] Namchi={"Namchi"};
    String[] Gyalshing={"Gyalshing"};
    String[] Pakyong={"Pakyong"};
    String[] Soreng={"Soreng"};
    String[] Chennai={"Chennai"};
    String[] Coimbatore={"Coimbatore"};
    String[] Madural={"Madural"};
    String[] Tiruchirappalli={"Tiruchirappalli"};
    String[] Salem={"Salem"};
    String[] Tirunelveli={"Tirunelveli"};
    String[] Tiruppur={"Tiruppur"};
    String[] Vellore={"Vellore"};
    String[] Erode={"Erode"};
    String[] Thoothukkudi={"Thoothukkudi"};
    String[] Dindigul={"Dindigul"};
    String[] Thanjavur={"Thanjavur"};
    String[] Ranipet={"Ranipet"};
    String[] Sivakasi={"Sivakasi"};
    String[] Karur={"Karur"};
    String[] Udhagamandalam={"Udhagamandalam"};
    String[] Hosur={"Hosur"};
    String[] Nagercoil={"Nagercoil"};
    String[] Kanchipuram={"Kanchipuram"};
    String[] Kumarapalayam={"Kumarapalayam"};
    String[] Karaikkudi={"Karaikkudi"};
    String[] Neyveli={"Neyveli"};
    String[] Cuddalore={"Cuddalore"};
    String[] Kumbakonam={"Kumbakonam"};
    String[] Tiruvannamalai={"Tiruvannamalai"};
    String[] Pollachi={"Pollachi"};
    String[] Rajapalayam={"Rajapalayam"};
    String[] Gudiyatham={"Gudiyatham"};
    String[] Pudukkottai={"Pudukkottai"};
    String[] Vaniyambadi={"Vaniyambadi"};
    String[] Ambur={"Ambur"};
    String[] Nagapattinam={"Nagapattinam"};
    String[] Hyderabad={"Hyderabad"};
    String[] Warangala={"Warangala"};
    String[] Nizamabad={"Nizamabad"};
    String[] Khammam={"Khammam"};
    String[] Karimnagar={"Karimnagar"};
    String[] Ramagundam={"Ramagundam"};
    String[] Mahabubnagar={"Mahabubnagar"};
    String[] Nalgonda={"Nalgonda"};
    String[] Adilabad={"Adilabad"};
    String[] Suryapet ={"Suryapet "};
    String[] Siddipet={"Siddipet"};
    String[] Miryalaguda={"Miryalaguda"};
    String[] Jagtial={"Jagtial"};
    String[] Mancherial={"Mancherial"};
    String[] Nimal={"Nimal"};
    String[] Sircilla={"Sircilla"};
    String[] Kamareddy={"Kamareddy"};
    String[] Palwancha={"Palwancha"};
    String[] Kothagudem={"Kothagudem"};
    String[] Bodhan={"Bodhan"};
    String[] Sangareddy={"Sangareddy"};
    String[] Metpally={"Metpally"};
    String[] Zahirabad={"Zahirabad"};
    String[] MeerpetJillelguda={"MeerpetJillelguda"};
    String[] Korutla={"Korutla"};
    String[] Tandur={"Tandur"};
    String[] Badangpet={"Badangpet"};
    String[] Kodad={"Kodad"};
    String[] Armur={"Armur"};
    String[] Gadwal={"Gadwal"};
    String[] Wanaparthy={"Wanaparthy"};
    String[] Kagaznagar={"Kagaznagar"};
    String[] Bellampalle={"Bellampalle"};
    String[] KhanapuramHaveli={"KhanapuramHaveli"};
    String[] Bhuvanagiri={"Bhuvanagiri"};
    String[] Vikarabad={"Vikarabad"};
    String[] Jangaon={"Jangaon"};
    String[] Mandamam={"Mandamam"};
    String[] Peerzadiguda={"Peerzadiguda"};
    String[] Bhadrachalam={"Bhadrachalam"};
    String[] Bhainsa={"Bhainsa"};
    String[] Boduppal={"Boduppal"};
    String[] Jawaharnagar={"Jawaharnagar"};
    String[] Medak={"Medak"};
    String[] Shamshabad={"Shamshabad"};
    String[] Mahabubabad={"Mahabubabad"};
    String[] Bhupalpally={"Bhupalpally"};
    String[] Narayanpet={"Narayanpet"};
    String[] Peddapaill={"Peddapaill"};
    String[] Dundigal={"Dundigal"};
    String[] Huzumagar={"Huzumagar"};
    String[] Medchal={"Medchal"};
    String[] BandlagudaJagir={"BandlagudaJagir"};
    String[] Kyathanpally={"Kyathanpally"};
    String[] Manuguru={"Manuguru"};
    String[] Naspur={"Naspur"};
    String[] Narsampet={"Narsampet"};
    String[] Devarakonda={"Devarakonda"};
    String[] Dubbaka={"Dubbaka"};
    String[] Nakrekal={"Nakrekal"};
    String[] Banswada={"Banswada"};
    String[] Kalwakurthy={"Kalwakurthy"};
    String[] NagarKurnool={"NagarKurnool"};
    String[] Parigi={"Parigi"};
    String[] Thumkunta={"Thumkunta"};
    String[] Neredcherla={"Neredcherla"};
    String[] Nagaram={"Nagaram"};
    String[] Gajwel={"Gajwel"};
    String[] Chennur={"Chennur"};
    String[] Asifabad={"Asifabad"};
    String[] Madhira={"Madhira"};
    String[] Ghatkesar={"Ghatkesar"};
    String[] Kompally={"Kompally"};
    String[] Dasnapur={"Dasnapur"};
    String[] Sarapaka={"Sarapaka"};
    String[] Husnabad={"Husnabad"};
    String[] Pocharam={"Pocharam"};
    String[] Dammaiguda={"Dammaiguda"};
    String[] Achampet={"Achampet"};
    String[] Agartala={"Agartala"};
    String[] Dharmanagar={"Dharmanagar"};
    String[] Udaipurr={"Udaipur"};
    String[] Kailashahar={"Kailashahar"};
    String[] Bishalgarh={"Bishalgarh"};
    String[] Teliamura={"Teliamura"};
    String[] Khowai={"Khowai"};
    String[] Belonia={"Belonia"};
    String[] Melaghar={"Melaghar"};
    String[] Mohanpur={"Mohanpur"};
    String[] Ambassa={"Ambassa"};
    String[] Ranirbazar={"Ranirbazar"};
    String[] Santirbazar={"Santirbazar"};
    String[] Kumarghat={"Kumarghat"};
    String[] Sonamura={"Sonamura"};
    String[] Panisagar={"Panisagar"};
    String[] Amarpur={"Amarpur"};
    String[] Jirania={"Jirania"};
    String[] Kamalpur={"Kamalpur"};
    String[] Sabroom={"Sabroom"};
    String[] Kanpur={"Kanpur"};
    String[] Lucknow={"Lucknow"};
    String[] Ghaziabad={"Ghaziabad"};
    String[] Meerut={"Meerut"};
    String[] Varanasi={"Varanasi"};
    String[] Prayagraj={"Prayagraj"};
    String[] Bareilly={"Bareilly"};
    String[] Moradabad={"Moradabad"};
    String[] Saharanpur={"Saharanpur"};
    String[] Gorakhpur={"Gorakhpur"};
    String[] Noida={"Noida"};
    String[] Firozabad={"Firozabad"};
    String[] Jhansi={"Jhansi"};
    String[] Muzaffarnagar={"Muzaffarnagar"};
    String[] Goverdhan={"Goverdhan"};
    String[] Vrindavan={"Vrindavan"};
    String[] Budaun={"Budaun"};
    String[] Raampur={"Rampur"};
    String[] Shahjahanpur={"Shahjahanpur"};
    String[] FarrukhabadcumFategarh={"FarrukhabadcumFategarh"};
    String[] FaizabadandAyodhya={"FaizabadandAyodhya"};
    String[] MaunathBhanjan={"MaunathBhanjan"};
    String[] Hapur={"Hapur"};
    String[] Ayodhya={"Ayodhya"};
    String[] Etawah={"Etawah"};
    String[] MirzapurcumVindhyachal={"MirzapurcumVindhyachal"};
    String[] Bulandshahr={"Bulandshahr"};
    String[] Sambhal={"Sambhal"};
    String[] Amroha={"Amroha"};
    String[] Hardoi={"Hardoi"};
    String[] Fatehpur={"Fatehpur"};
    String[] Raebareli={"Raebareli"};
    String[] Orai={"Orai"};
    String[] Sitapur={"Sitapur"};
    String[] Bahraich={"Bahraich"};
    String[] Modinagar={"Modinagar"};
    String[] Unnao={"Unnao"};
    String[] Jaunpur={"Jaunpur"};
    String[] Lakhimpur={"Lakhimpur"};
    String[] Hathras={"Hathras"};
    String[] Banda={"Banda"};
    String[] Pilibhit={"Pilibhit"};
    String[] Barabanki={"Barabanki"};
    String[] Khurja={"Khurja"};
    String[] Gonda={"Gonda"};
    String[] Mainpuri={"Mainpuri"};
    String[] Lalitpur={"Lalitpur"};
    String[] Etah={"Etah"};
    String[] Deoria={"Deoria"};
    String[] Ujhani={"Ujhani"};
    String[] Ghazipur={"Ghazipur"};
    String[] Sultanpur={"Sultanpur"};
    String[] Azamgarh={"Azamgarh"};
    String[] Bijnor={"Bijnor"};
    String[] Sahaswan={"Sahaswan"};
    String[] Basti={"Basti"};
    String[] Chandausi={"Chandausi"};
    String[] Akbarpur={"Akbarpur"};
    String[] Ballia={"Ballia"};
    String[] Tanda={"Tanda"};
    String[] GreaterNoida={"GreaterNoida"};
    String[] Shikohabad={"Shikohabad"};
    String[] Shamli={"Shamli"};
    String[] Awagarh={"Awagarh"};
    String[] Kasganj={"Kasganj"};
    String[] Dehradun={"Dehradun"};
    String[] Haridwar={"Haridwar"};
    String[] Roorkee={"Roorkee"};
    String[] HaldwanicumKathgodamNainital={"HaldwanicumKathgodamNainital"};
    String[] Rudrapur={"Rudrapur"};
    String[] Kashipur={"Kashipur"};
    String[] Rishikesh={"Rishikesh"};
    String[] Kolkata={"Kolkata"};
    String[] Asansol={"Asansol"};
    String[] Siliguri={"Siliguri"};
    String[] Durgapur={"Durgapur"};
    String[] Bardhaman={"Bardhaman"};
    String[] Malda={"Malda"};
    String[] Baharampur={"Baharampur"};
    String[] Habra={"Habra"};
    String[] Kharagpur={"Kharagpur"};
    String[] Shantipur={"Shantipur"};
    String[] Dankuni={"Dankuni"};
    String[] Dhulian={"Dhulian"};
    String[] Ranaghat={"Ranaghat"};
    String[] Haldia={"Haldia"};
    String[] Raiganj={"Raiganj"};
    String[] Krishnanagar={"Krishnanagar"};
    String[] Nabadwip={"Nabadwip"};
    String[] Medinipur={"Medinipur"};
    String[] Jalpaiguri={"Jalpaiguri"};
    String[] Balurghat={"Balurghat"};
    String[] Basirhat={"Basirhat"};
    String[] Bankura={"Bankura"};
    String[] Chakdaha={"Chakdaha"};
    String[] Darjeeling={"Darjeeling"};
    String[] Alipurduar={"Alipurduar"};
    String[] Purulia={"Purulia"};
    String[] Jangipur={"Jangipur"};
    String[] Bolpur={"Bolpur"};
    String[] Bangaon={"Bangaon"};
    String[] CoochBehar={"CoochBehar"};


    TextInputLayout Fname, Lname, Pass, cfpass, mobileno, houseno, area, postcode, Email;
    Spinner statespin, Cityspin, Suburban;
    Button signup, Emaill, Phone;
    CountryCodePicker Cpp;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth FAuth;
    String role = "DeliveryPerson";
    String statee, cityy, suburban, fname, lname, mobile, confirmpassword, password, Area, Postcode, house, emailid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_registeration);

        Fname = (TextInputLayout) findViewById(R.id.fname);
        Lname = (TextInputLayout) findViewById(R.id.lname);
        Pass = (TextInputLayout) findViewById(R.id.password);
        Email = (TextInputLayout) findViewById(R.id.Emailid);
        cfpass = (TextInputLayout) findViewById(R.id.confirmpassword);
        mobileno = (TextInputLayout) findViewById(R.id.mobileno);
        houseno = (TextInputLayout) findViewById(R.id.Houseno);
        area = (TextInputLayout) findViewById(R.id.Areaa);
        postcode = (TextInputLayout) findViewById(R.id.Postcodee);
        statespin = (Spinner) findViewById(R.id.State);
        Cityspin = (Spinner) findViewById(R.id.City);
        Emaill = (Button) findViewById(R.id.emaillid);
        Suburban = (Spinner) findViewById(R.id.suburban);
        signup = (Button) findViewById(R.id.Signupp);
        Phone = (Button) findViewById(R.id.Phonenumber);
        Cpp = (CountryCodePicker) findViewById(R.id.ctrycode);
        final ProgressDialog mDialog = new ProgressDialog(Delivery_registeration.this);
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);


        statespin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object value = parent.getItemAtPosition(position);
                statee = value.toString().trim();
                if (statee.equals("Maharashtra")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Maharashtra) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("UttarPradesh")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : UttarPradesh) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("AndhraPradesh")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : AndhraPradesh) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("ArunachalPradesh")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : ArunachalPradesh) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Assam")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Assam) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Bihar")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Bihar) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Chandigarh")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Chandigarh) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Chattisgarh")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Chattisgarh) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("DadraandNagarHaveli")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : DadraandNagarHaveli) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("DamanandDiu")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : DamanandDiu) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Delhi")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Delhi) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Goa")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Goa) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Gujarat")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Gujarat) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Haryana")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Haryana) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("HimachalPradesh")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : HimachalPradesh) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("JammuandKashmir")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : JammuandKashmir) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Jharkhand")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Jharkhand) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Karnataka")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Karnataka) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Kerala")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Kerala) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Ladakh")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Ladakh) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("MadhyaPradesh")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : MadhyaPradesh) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Manipur")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Manipur) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Meghalaya")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Meghalaya) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Mizoram")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Mizoram) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Nagaland")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Nagaland) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Odisha")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Odisha) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Puducherry")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Puducherry) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Punjab")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Punjab) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Rajasthan")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Rajasthan) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Sikkim")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Sikkim) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("TamilNadu")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : TamilNadu) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Telangana")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Telangana) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Tripura")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Tripura) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("Uttarakhand")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : Uttarakhand) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }
                if (statee.equals("WestBengal")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String text : WestBengal) {
                        list.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, list);

                    Cityspin.setAdapter(arrayAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Cityspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object value = parent.getItemAtPosition(position);
                cityy = value.toString().trim();
                if (cityy.equals("Mumbai")) {
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mumbai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }

                if (cityy.equals("Pune")) {
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pune) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }

                if (cityy.equals("Aurangabad")) {
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Aurangabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }

                if (cityy.equals("Mathura")) {
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mathura) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Aligarh")) {
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Aligarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Agra")) {
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Agra) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Visakhapatnam")) {
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Visakhapatnam) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Vijayawada")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Vijayawada) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Guntur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Guntur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nellore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nellore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kurnool")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kurnool) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kakinada")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kakinada) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rajahmundry")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rajahmundry) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kadapa")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kadapa) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tirupati")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tirupati) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Anantapuram")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Anantapuram) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Vizianagaram")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Vizianagaram) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Eluru")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Eluru) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nandyal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nandyal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ongole")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ongole) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Adoni")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Adoni) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Madanapalle")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Madanapalle) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Machilipatnam")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Machilipatnam) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tenali")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tenali) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Proddatur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Proddatur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chittoor")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chittoor) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hindupur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hindupur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Srikakulam")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Srikakulam) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhimavaram")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhimavaram) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tadepalligudem")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tadepalligudem) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Guntakal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Guntakal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dharmavaram")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dharmavaram) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gudivada")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gudivada) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Narasaraopet")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Narasaraopet) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kadiri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kadiri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tadipatri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tadipatri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mangalagin")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mangalagin) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chilakaluripet")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chilakaluripet) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("ChanglangDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : ChanglangDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("DibangValleyDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : DibangValleyDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("EastKamengDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : EastKamengDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("EastSiangDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : EastSiangDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("KurungKumeyDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : KurungKumeyDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("LohitDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : LohitDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("LowerDibangValleyDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : LowerDibangValleyDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("LowerSubansiriDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : LowerSubansiriDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("PapumPareDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : PapumPareDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("TawangDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : TawangDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("TirapDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : TirapDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("UpperSiangDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : UpperSiangDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("UpperSubansiriDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : UpperSubansiriDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("WestKamengDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : WestKamengDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("WestSiangDistrict")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : WestSiangDistrict) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Guwahat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Guwahat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Silchar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Silchar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dibrugarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dibrugarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jorhat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jorhat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nagaon")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nagaon) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bongaigaon")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bongaigaon) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tinsukia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tinsukia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tezpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tezpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Diphu")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Diphu) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dhubri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dhubri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("NorthLakhimpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : NorthLakhimpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Karimganj")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Karimganj) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sivasagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sivasagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Goalpara")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Goalpara) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("BarpetaTown")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : BarpetaTown) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Golaghat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Golaghat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hafiong")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hafiong) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mangaldai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mangaldai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tangla")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tangla) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Lanka")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Lanka) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hojai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hojai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("BarpetaRoad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : BarpetaRoad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kokrajhar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kokrajhar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hailakandi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hailakandi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Morigaon")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Morigaon) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nalbari")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nalbari) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rangia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rangia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Silapathar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Silapathar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dhekiajuli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dhekiajuli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dergaon")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dergaon) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sonari")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sonari) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kharupetia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kharupetia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nazira")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nazira) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Lakhipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Lakhipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Patna")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Patna) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gaya")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gaya) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhagalpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhagalpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Purnia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Purnia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Muzafaffarpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Muzafaffarpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Darbhanga")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Darbhanga) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("BiharShaif")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : BiharShaif) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Arrah")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Arrah) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Begusald")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Begusald) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Katihar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Katihar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Munger")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Munger) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chhapra")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chhapra) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Danapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Danapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bettian")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bettian) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("saharsa")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : saharsa) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hajipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hajipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sasaram")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sasaram) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dehri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dehri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Siwan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Siwan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Motihar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Motihar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nawada")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nawada) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bagand")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bagand) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Buxar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Buxar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kishanganj")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kishanganj) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sitamarhi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sitamarhi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jamalpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jamalpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jehanabad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jehanabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Aurangabad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Aurangabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chandigarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chandigarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("NayaRaipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : NayaRaipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Raipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Raipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhilai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhilai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bilaspur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bilaspur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Korba")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Korba) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rajnandgaon")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rajnandgaon) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Raigarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Raigarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ambikapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ambikapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jagdalpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jagdalpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chirmiri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chirmiri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dhamtari")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dhamtari) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mahasamund")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mahasamund) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("DadraandNagarHaveli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : DadraandNagarHaveli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("DamanandDiu")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : DamanandDiu) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Delhi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Delhi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bicholim")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bicholim) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Canacona")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Canacona) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Cuncolim")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Cuncolim) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Curchorem")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Curchorem) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mapusa")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mapusa) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Margao")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Margao) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mormugao")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mormugao) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Panaji")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Panaji) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Pernem")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pernem) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ponda")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ponda) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Quepem")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Quepem) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sanguem")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sanguem) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sanquelim")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sanquelim) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Valpoi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Valpoi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Amdavad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Amdavad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Surat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Surat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Vadodara")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Vadodara) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rajkot")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rajkot) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhavnagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhavnagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jamnagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jamnagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gandhinagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gandhinagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Junagadh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Junagadh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gandhidham")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gandhidham) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Anand")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Anand) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Navsari")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Navsari) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Morbi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Morbi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nadiad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nadiad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Surendranagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Surendranagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bharuch")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bharuch) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mehsana")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mehsana) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhuj")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhuj) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Porbandar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Porbandar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Palanpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Palanpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Valsad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Valsad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Vapi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Vapi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gondal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gondal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Veraval")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Veraval) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Godhra")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Godhra) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Patan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Patan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kalol")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kalol) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dahod")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dahod) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Botad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Botad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Amreli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Amreli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Deesa")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Deesa) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jetpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jetpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Faridabad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Faridabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gurugram")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gurugram) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Panipat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Panipat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ambala")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ambala) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Yamunanagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Yamunanagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rohtak")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rohtak) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hisar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hisar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Karnal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Karnal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sonipat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sonipat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Panchkula")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Panchkula) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhiwani")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhiwani) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sirsa")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sirsa) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bahadurgarn")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bahadurgarn) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jind")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jind) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Thanesar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Thanesar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kaithal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kaithal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rewari")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rewari) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Narnaul")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Narnaul) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Pundri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pundri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kosli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kosli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Palwal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Palwal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Shimla")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Shimla) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dharamsala")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dharamsala) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Solan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Solan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mandi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mandi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Palampur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Palampur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Baddi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Baddi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nahan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nahan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("PaontaSahib")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : PaontaSahib) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sundanagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sundanagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chamba")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chamba) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Una")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Una) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kullu")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kullu) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hamirpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hamirpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bilaspur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bilaspur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("YolCantonment")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : YolCantonment) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nalagarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nalagarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nurpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nurpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kangra")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kangra) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Santokhgarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Santokhgarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("MehatpurBasdehra")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : MehatpurBasdehra) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Shamshi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Shamshi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Parwanoo")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Parwanoo) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Manali")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Manali) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("TiraSujanpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : TiraSujanpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ghumarwin")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ghumarwin) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dalhousie")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dalhousie) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rohru")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rohru) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("NagrotaBagwan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : NagrotaBagwan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rampur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rampur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jawalamukhi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jawalamukhi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jogindernagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jogindernagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("DeraGopipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : DeraGopipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sarkaghat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sarkaghat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jhakhri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jhakhri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Indora")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Indora) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhuntar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhuntar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nadaun")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nadaun) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Theog")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Theog) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("KasauliCantonment")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : KasauliCantonment) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gagret")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gagret) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("ChuariKhas")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : ChuariKhas) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Daulatpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Daulatpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("SabathuCantonment")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : SabathuCantonment) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("DalhousieCantonment")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : DalhousieCantonment) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Raigarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Raigarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Arki")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Arki) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("DagshaiCantonment")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : DagshaiCantonment) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Seoni")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Seoni) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Talai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Talai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("JutoghCantonment")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : JutoghCantonment) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chaupal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chaupal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rewalsar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rewalsar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("BaklohCantonment")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : BaklohCantonment) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jubbal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jubbal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhota")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhota) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Banjar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Banjar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("NainaDevi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : NainaDevi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kotkhai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kotkhai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Narkanda")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Narkanda) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Srinagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Srinagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jammu")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jammu) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Anantnag")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Anantnag) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jamshedpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jamshedpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dhanbad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dhanbad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ranchi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ranchi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("BokaroSteelCity")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : BokaroSteelCity) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Deoghar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Deoghar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Phusro")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Phusro) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hazaribagh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hazaribagh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Giridih")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Giridih) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ramgarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ramgarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Medininagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Medininagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chirkunda")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chirkunda) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bangalore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bangalore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("HubliDharwad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : HubliDharwad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mysore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mysore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gulbarga")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gulbarga) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mangalore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mangalore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Belgaum")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Belgaum) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Davanagere")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Davanagere) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bellary")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bellary) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bijapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bijapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Shimoga")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Shimoga) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tumkur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tumkur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Raichur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Raichur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bidar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bidar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hospet")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hospet) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("GadagBetageri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : GadagBetageri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Robertsonpet")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Robertsonpet) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hassan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hassan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhadravati")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhadravati) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chitradurga")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chitradurga) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Udupi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Udupi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kolar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kolar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mandya")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mandya) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chikmagalur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chikmagalur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gangavati")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gangavati) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bagalkot")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bagalkot) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ranebennuru")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ranebennuru) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Thiruvananthapuram")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Thiruvananthapuram) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
//                    if (cityy.equals("Kozhikode")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kozhikode) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kochi")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kochi) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kollam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kollam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Thrissur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Thrissur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kannur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kannur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Alappuzha")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Alappuzha) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kottayam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kottayam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Palakkad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Palakkad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Manjeri")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Manjeri) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Thalassery")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Thalassery) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Ponnani")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Ponnani) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Vatakara")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Vatakara) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kanhangad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kanhangad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Payyanur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Payyanur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Koyilandy")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Koyilandy) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Parappanangadi")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Parappanangadi) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kalamassery")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kalamassery) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Neyyattinkara")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Neyyattinkara) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Tanur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Tanur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Thrippunithura")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Thrippunithura) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kayamkulam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kayamkulam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Malappuram")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Malappuram) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Thrikkakkara")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Thrikkakkara) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Wadakkancherry")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Wadakkancherry) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Nedumangad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Nedumangad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kondotty")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kondotty) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Tirurangad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Tirurangad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("irur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : irur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Panoor")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Panoor) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Nileshwaram")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Nileshwaram) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kasaragod")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kasaragod) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Feroke")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Feroke) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("KunnamkUlam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : KunnamkUlam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Ottappalam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Ottappalam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Tiruvalla")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Tiruvalla) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Thodupuzha")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Thodupuzha) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Perinthalmanna")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Perinthalmanna) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Chalakudy")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Chalakudy) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Payyoll")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Payyoll) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Koduvally")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Koduvally) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Mananthavady")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Mananthavady) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Changanassery")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Changanassery) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Mattanur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Mattanur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Punalur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Punalur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Nilambur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Nilambur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Cherthala")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Cherthala) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("SultanBathery")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : SultanBathery) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Maradu")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Maradu) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kottakkal")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kottakkal) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Taliparamba")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Taliparamba) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Shornur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Shornur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("ndalam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : ndalam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kattappana")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kattappana) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Mukkam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Mukkam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("ty")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : ty) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("chery")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : chery) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Varkala")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Varkala) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Cherpulassery")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Cherpulassery) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Chavakkad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Chavakkad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kothamangalam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kothamangalam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Pathanamthitta")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Pathanamthitta) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Atingal")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Atingal) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("aravur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : aravur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Ramanattukara")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Ramanattukara) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Mannarkkad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Mannarkkad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("rattupetta")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : rattupetta) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kodungallur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kodungallur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Sreekandapuram")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Sreekandapuram) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Anganiauy")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Anganiauy) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Chittur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Chittur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Thathamangalam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Thathamangalam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kalpetta")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kalpetta) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("NorthParavur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : NorthParavur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Haripad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Haripad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Muvattupuzha")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Muvattupuzha) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kottarakara")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kottarakara) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kuthuparamba")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kuthuparamba) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Adoor")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Adoor) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Piravom")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Piravom) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Irinjalakuda")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Irinjalakuda) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Pattambi")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Pattambi) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Anthoor")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Anthoor) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Perumbavoor")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Perumbavoor) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Ettumanoor")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Ettumanoor) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Mavelikkara")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Mavelikkara) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Karunagappalli")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Karunagappalli) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Eloor")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Eloor) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Chengannur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Chengannur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Vaikom")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Vaikom) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Aluva")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Aluva) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Pala")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Pala) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Guruvayur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Guruvayur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Koothattukulam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Koothattukulam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Avinissery")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Avinissery) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
                if (cityy.equals("Ladakh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ladakh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Indore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Indore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhopal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhopal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jabalpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jabalpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gwalior")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gwalior) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Katni")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Katni) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ujjain")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ujjain) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dewas")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dewas) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Satna")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Satna) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ratlam")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ratlam) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rewa")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rewa) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Singrauli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Singrauli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Burhanpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Burhanpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Khandwa")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Khandwa) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhind")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhind) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chhindwara")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chhindwara) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Guna")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Guna) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Shivpuri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Shivpuri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Vidisha")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Vidisha) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chhatarpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chhatarpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Damoh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Damoh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mandsaur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mandsaur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Khargone")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Khargone) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Neemuch")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Neemuch) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Pithampur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pithampur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Narmadapuram")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Narmadapuram) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Itarsi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Itarsi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sehore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sehore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Morena")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Morena) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Betul")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Betul) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Seoni")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Seoni) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Datia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Datia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nagda")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nagda) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dindori")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dindori) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mumbai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mumbai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Pune")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pune) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nagpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nagpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Thane")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Thane) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("PCMCPune")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : PCMCPune) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nashik")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nashik) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("KalyanDombivli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : KalyanDombivli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("VasaiVirarCityMC")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : VasaiVirarCityMC) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Aurangabad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Aurangabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("NaviMumbai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : NaviMumbai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Solapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Solapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("MiraBhayandar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : MiraBhayandar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("BhiwandiNizampurMC")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : BhiwandiNizampurMC) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jalgaon")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jalgaon) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Amravati")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Amravati) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nanded")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nanded) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kolhapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kolhapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ulhasnagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ulhasnagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("SangliMirajKupwad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : SangliMirajKupwad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Malegaon")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Malegaon) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Akola")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Akola) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Latur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Latur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dhule")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dhule) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ahmednagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ahmednagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chandrapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chandrapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Parbhani")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Parbhani) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ichalkaranji")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ichalkaranji) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jalna")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jalna) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ambarnath")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ambarnath) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhusawal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhusawal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Panvel")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Panvel) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Badlapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Badlapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Beed")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Beed) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gondia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gondia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Satara")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Satara) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Barshi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Barshi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Yavatmal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Yavatmal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Achalpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Achalpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Osmanabad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Osmanabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nandurbar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nandurbar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Wardha")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Wardha) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Udgir")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Udgir) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hinganghat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hinganghat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bishnupur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bishnupur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Thoubal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Thoubal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("ImphalEast")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : ImphalEast) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("ImphalWest")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : ImphalWest) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Senapati")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Senapati) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ukhrul")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ukhrul) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chandel")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chandel) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Churachandpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Churachandpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tamenglong")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tamenglong) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jiribam")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jiribam) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kangpokpi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kangpokpi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kakching")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kakching) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tengnoupal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tengnoupal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kamjong")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kamjong) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Noney")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Noney) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Pherzawi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pherzawi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Meghalaya")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Meghalaya) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Aizawl")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Aizawl) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kolasib")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kolasib) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Lawngtlai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Lawngtlai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Lunglei")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Lunglei) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mamit")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mamit) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Saiha")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Saiha) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Serchhip")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Serchhip) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Champhai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Champhai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hnahthial")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hnahthial) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Khawzawl")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Khawzawl) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Saitual")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Saitual) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dimapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dimapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kiphire")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kiphire) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kohima")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kohima) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Longleng")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Longleng) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mokokchung")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mokokchung) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mon")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mon) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Peren")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Peren) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Phek")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Phek) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tuensang")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tuensang) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Wokha")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Wokha) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Zunhebote")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Zunhebote) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhubaneswar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhubaneswar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Cuttack")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Cuttack) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rourkela")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rourkela) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Berhampur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Berhampur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sambalpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sambalpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Puri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Puri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Balasore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Balasore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhadrak")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhadrak) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Baripada")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Baripada) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Puducherry")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Puducherry) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ludhiana")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ludhiana) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Amritsar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Amritsar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jalandhar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jalandhar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Patiala")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Patiala) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bathinda")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bathinda) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mohali")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mohali) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Firozpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Firozpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Batala")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Batala) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Pathankot")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pathankot) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Moga")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Moga) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Abohar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Abohar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Malerkotla")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Malerkotla) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Khanna")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Khanna) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Phagwara")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Phagwara) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Muktsar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Muktsar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Barnala")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Barnala) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rajpura")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rajpura) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hoshiarpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hoshiarpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kapurthala")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kapurthala) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Faridkot")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Faridkot) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sunam")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sunam) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jaipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jaipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jodhpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jodhpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kota ")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kota ) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhiwadi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhiwadi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bikaner")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bikaner) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Udaipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Udaipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ajmer")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ajmer) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bhilwara")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bhilwara) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Alwar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Alwar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sikar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sikar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bharatpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bharatpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Pali")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pali) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("SriGanganagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : SriGanganagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kishangarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kishangarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Baran")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Baran) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dhaulpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dhaulpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tonk")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tonk) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Beawar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Beawar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hanumangarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hanumangarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gangtok")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gangtok) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mangan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mangan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Namchi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Namchi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gyalshing")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gyalshing) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Pakyong")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pakyong) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Soreng")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Soreng) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chennai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chennai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Coimbatore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Coimbatore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Madural")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Madural) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tiruchirappalli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tiruchirappalli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Salem")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Salem) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tirunelveli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tirunelveli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tiruppur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tiruppur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Vellore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Vellore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Erode")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Erode) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Thoothukkudi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Thoothukkudi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dindigul")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dindigul) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Thanjavur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Thanjavur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ranipet")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ranipet) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sivakasi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sivakasi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Karur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Karur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Udhagamandalam")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Udhagamandalam) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hosur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hosur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nagercoil")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nagercoil) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kanchipuram")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kanchipuram) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kumarapalayam")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kumarapalayam) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Karaikkudi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Karaikkudi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Neyveli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Neyveli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Cuddalore")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Cuddalore) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kumbakonam")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kumbakonam) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tiruvannamalai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tiruvannamalai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
//                    if (cityy.equals("Pollachi")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Pollachi) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Rajapalayam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Rajapalayam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Gudiyatham")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Gudiyatham) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Pudukkottai")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Pudukkottai) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Vaniyambadi")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Vaniyambadi) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Ambur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Ambur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Nagapattinam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Nagapattinam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Hyderabad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Hyderabad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Warangala")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Warangala) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Nizamabad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Nizamabad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Khammam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Khammam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Karimnagar")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Karimnagar) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Ramagundam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Ramagundam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Mahabubnagar")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Mahabubnagar) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Nalgonda")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Nalgonda) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Adilabad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Adilabad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Suryapet ")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Suryapet ) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Siddipet")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Siddipet) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Miryalaguda")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Miryalaguda) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Jagtial")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Jagtial) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Mancherial")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Mancherial) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Nimal")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Nimal) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Sircilla")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Sircilla) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kamareddy")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kamareddy) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Palwancha")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Palwancha) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kothagudem")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kothagudem) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Bodhan")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Bodhan) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Sangareddy")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Sangareddy) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Metpally")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Metpally) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Zahirabad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Zahirabad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("MeerpetJillelguda")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : MeerpetJillelguda) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Korutla")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Korutla) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Tandur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Tandur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Badangpet")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Badangpet) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kodad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kodad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Armur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Armur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Gadwal")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Gadwal) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Wanaparthy")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Wanaparthy) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kagaznagar")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kagaznagar) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Bellampalle")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Bellampalle) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("KhanapuramHaveli")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : KhanapuramHaveli) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Bhuvanagiri")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Bhuvanagiri) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Vikarabad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Vikarabad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Jangaon")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Jangaon) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Mandamam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Mandamam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Peerzadiguda")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Peerzadiguda) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Bhadrachalam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Bhadrachalam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Bhainsa")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Bhainsa) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Boduppal")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Boduppal) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Jawaharnagar")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Jawaharnagar) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Medak")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Medak) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Shamshabad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Shamshabad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Mahabubabad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Mahabubabad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Bhupalpally")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Bhupalpally) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Narayanpet")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Narayanpet) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Peddapaill")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Peddapaill) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Dundigal")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Dundigal) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Huzumagar")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Huzumagar) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Medchal")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Medchal) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("BandlagudaJagir")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : BandlagudaJagir) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kyathanpally")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kyathanpally) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Manuguru")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Manuguru) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Naspur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Naspur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Narsampet")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Narsampet) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Devarakonda")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Devarakonda) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Dubbaka")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Dubbaka) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Nakrekal")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Nakrekal) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Banswada")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Banswada) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kalwakurthy")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kalwakurthy) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("NagarKurnool")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : NagarKurnool) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Parigi")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Parigi) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Thumkunta")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Thumkunta) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Neredcherla")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Neredcherla) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Nagaram")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Nagaram) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Gajwel")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Gajwel) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Chennur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Chennur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Asifabad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Asifabad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Madhira")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Madhira) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Ghatkesar")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Ghatkesar) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Kompally")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Kompally) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Dasnapur")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Dasnapur) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Sarapaka")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Sarapaka) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Husnabad")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Husnabad) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Pocharam")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Pocharam) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Dammaiguda")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Dammaiguda) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
//                    if (cityy.equals("Achampet")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : Achampet) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }
                if (cityy.equals("Agartala")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Agartala) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dharmanagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dharmanagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Udaipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Udaipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kailashahar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kailashahar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bishalgarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bishalgarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Teliamura")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Teliamura) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Khowai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Khowai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Belonia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Belonia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Melaghar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Melaghar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mohanpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mohanpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ambassa")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ambassa) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ranirbazar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ranirbazar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Santirbazar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Santirbazar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kumarghat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kumarghat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sonamura")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sonamura) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Panisagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Panisagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Amarpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Amarpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jirania")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jirania) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kamalpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kamalpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sabroom")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sabroom) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mathura")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mathura) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Agra")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Agra) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Aligarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Aligarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kanpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kanpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Lucknow")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Lucknow) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ghaziabad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ghaziabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Meerut")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Meerut) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Varanasi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Varanasi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Prayagraj")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Prayagraj) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bareilly")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bareilly) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Moradabad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Moradabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Saharanpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Saharanpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gorakhpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gorakhpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Noida")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Noida) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Firozabad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Firozabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jhansi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jhansi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Muzaffarnagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Muzaffarnagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Goverdhan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Goverdhan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Vrindavan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Vrindavan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Budaun")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Budaun) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rampur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rampur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Shahjahanpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Shahjahanpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("FarrukhabadcumFategarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : FarrukhabadcumFategarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("FaizabadandAyodhya")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : FaizabadandAyodhya) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("MaunathBhanjan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : MaunathBhanjan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ayodhya")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ayodhya) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Etawah")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Etawah) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("MirzapurcumVindhyachal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : MirzapurcumVindhyachal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bulandshahr")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bulandshahr) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sambhal")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sambhal) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Amroha")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Amroha) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hardoi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hardoi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Fatehpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Fatehpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Raebareli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Raebareli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Orai")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Orai) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sitapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sitapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bahraich")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bahraich) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Modinagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Modinagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Unnao")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Unnao) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jaunpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jaunpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Lakhimpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Lakhimpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Hathras")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Hathras) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Banda")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Banda) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Pilibhit")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Pilibhit) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Barabanki")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Barabanki) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Khurja")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Khurja) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Gonda")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Gonda) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Mainpuri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Mainpuri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Lalitpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Lalitpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Etah")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Etah) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Deoria")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Deoria) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ujhani")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ujhani) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ghazipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ghazipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sultanpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sultanpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Azamgarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Azamgarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bijnor")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bijnor) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Sahaswan")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Sahaswan) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Basti")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Basti) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chandausi")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chandausi) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Akbarpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Akbarpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ballia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ballia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Tanda")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Tanda) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("GreaterNoida")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : GreaterNoida) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Shikohabad")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Shikohabad) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Shamli")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Shamli) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Awagarh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Awagarh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kasganj")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kasganj) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dehradun")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dehradun) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Haridwar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Haridwar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Roorkee")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Roorkee) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("HaldwanicumKathgodamNainital")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : HaldwanicumKathgodamNainital) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rudrapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rudrapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kashipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kashipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Rishikesh")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Rishikesh) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kolkata")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kolkata) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Asansol")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Asansol) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Siliguri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Siliguri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Durgapur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Durgapur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bardhaman")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bardhaman) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Malda")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Malda) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Baharampur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Baharampur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Habra")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Habra) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Kharagpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Kharagpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Shantipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Shantipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dankuni")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dankuni) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Dhulian")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Dhulian) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Ranaghat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Ranaghat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Haldia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Haldia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Raiganj")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Raiganj) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Krishnanagar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Krishnanagar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Nabadwip")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Nabadwip) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Medinipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Medinipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jalpaiguri")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jalpaiguri) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Balurghat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Balurghat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Basirhat")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Basirhat) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bankura")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bankura) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Chakdaha")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Chakdaha) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Darjeeling")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Darjeeling) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Alipurduar")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Alipurduar) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Purulia")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Purulia) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Jangipur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Jangipur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bolpur")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bolpur) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
                if (cityy.equals("Bangaon")){
                    ArrayList<String> listt = new ArrayList<>();
                    for (String text : Bangaon) {
                        listt.add(text);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
                    Suburban.setAdapter(arrayAdapter);
                }
//                    if (cityy.equals("CoochBehar")){
//                        ArrayList<String> listt = new ArrayList<>();
//                        for (String text : CoochBehar) {
//                            listt.add(text);
//                        }
//                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Delivery_registeration.this, android.R.layout.simple_spinner_item, listt);
//                        Suburban.setAdapter(arrayAdapter);
//                    }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Suburban.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object value = parent.getItemAtPosition(position);
                suburban = value.toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        databaseReference = firebaseDatabase.getInstance().getReference("DeliveryPerson");
        FAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fname = Fname.getEditText().getText().toString().trim();
                lname = Lname.getEditText().getText().toString().trim();
                mobile = mobileno.getEditText().getText().toString().trim();
                emailid = Email.getEditText().getText().toString().trim();
                password = Pass.getEditText().getText().toString().trim();
                confirmpassword = cfpass.getEditText().getText().toString().trim();
                Area = area.getEditText().getText().toString().trim();
                house = houseno.getEditText().getText().toString().trim();
                Postcode = postcode.getEditText().getText().toString().trim();

                if (isValid()) {


                    mDialog.setMessage("Registering please wait...");
                    mDialog.show();

                    FAuth.createUserWithEmailAndPassword(emailid, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String useridd = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                databaseReference = FirebaseDatabase.getInstance().getReference("User").child(useridd);
                                final HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("Role", role);
                                databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {

                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        HashMap<String, String> hashMappp = new HashMap<>();
                                        hashMappp.put("Area", Area);
                                        hashMappp.put("City", cityy);
                                        hashMappp.put("ConfirmPassword", confirmpassword);
                                        hashMappp.put("EmailID", emailid);
                                        hashMappp.put("Fname", fname);
                                        hashMappp.put("House", house);
                                        hashMappp.put("Lname", lname);
                                        hashMappp.put("Mobile", mobile);
                                        hashMappp.put("Password", password);
                                        hashMappp.put("Postcode", Postcode);
                                        hashMappp.put("State", statee);
                                        hashMappp.put("Suburban", suburban);
                                        firebaseDatabase.getInstance().getReference("DeliveryPerson").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(hashMappp).addOnCompleteListener(new OnCompleteListener<Void>() {

                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                mDialog.dismiss();

                                                FAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(Delivery_registeration.this);
                                                            builder.setMessage("Registered Successfully, Please Check Your Mail and Verify By Clicking on The Link. If not able to find, Check Your Spam Folder. After Verifying, You Can Sign-In With Your Email ID");
                                                            builder.setCancelable(false);
                                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {

                                                                    dialog.dismiss();

                                                                    String phonenumber = Cpp.getSelectedCountryCodeWithPlus() + mobile;
                                                                    Intent b = new Intent(Delivery_registeration.this, Delivery_Login.class);
                                                                    b.putExtra("phonenumber", phonenumber);
                                                                    startActivity(b);

                                                                }
                                                            });
                                                            AlertDialog alert = builder.create();
                                                            alert.show();

                                                        } else {
                                                            mDialog.dismiss();
                                                            ReusableCodeForAll.ShowAlert(Delivery_registeration.this, "Error", task.getException().getMessage());

                                                        }
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });


                            } else {
                                mDialog.dismiss();
                                ReusableCodeForAll.ShowAlert(Delivery_registeration.this, "Error", task.getException().getMessage());
                            }

                        }
                    });


                }
            }
        });

        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent e = new Intent(Delivery_registeration.this, Delivery_LoginPhone.class);
                startActivity(e);
                finish();
            }
        });

        Emaill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Delivery_registeration.this, Delivery_Login.class);
                startActivity(a);
                finish();
            }
        });


    }

    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public boolean isValid() {
        Fname.setErrorEnabled(false);
        Fname.setError("");
        Email.setErrorEnabled(false);
        Email.setError("");
        Lname.setErrorEnabled(false);
        Lname.setError("");
        Pass.setErrorEnabled(false);
        Pass.setError("");
        mobileno.setErrorEnabled(false);
        mobileno.setError("");
        cfpass.setErrorEnabled(false);
        cfpass.setError("");
        area.setErrorEnabled(false);
        area.setError("");
        houseno.setErrorEnabled(false);
        houseno.setError("");
        postcode.setErrorEnabled(false);
        postcode.setError("");

        boolean isValidname = false, isvalidpassword = false, isValidemail = false, isvalidconfirmpassword = false, isvalid = false, isvalidmobileno = false, isvalidlname = false, isvalidhousestreetno = false, isvalidarea = false, isvalidpostcode = false;
        if (TextUtils.isEmpty(fname)) {
            Fname.setErrorEnabled(true);
            Fname.setError("Firstname is required");
        } else {
            isValidname = true;
        }
        if (TextUtils.isEmpty(lname)) {
            Lname.setErrorEnabled(true);
            Lname.setError("Lastname is required");
        } else {
            isvalidlname = true;
        }
        if (TextUtils.isEmpty(emailid)) {
            Email.setErrorEnabled(true);
            Email.setError("Email is required");
        } else {
            if (emailid.matches(emailpattern)) {
                isValidemail = true;
            } else {
                Email.setErrorEnabled(true);
                Email.setError("Enter a valid Email Address");
            }

        }

        if (TextUtils.isEmpty(password)) {
            Pass.setErrorEnabled(true);
            Pass.setError("Password is required");
        } else {
            if (password.length() < 6) {
                Pass.setErrorEnabled(true);
                Pass.setError("password too weak");
            } else {
                isvalidpassword = true;
            }
        }
        if (TextUtils.isEmpty(confirmpassword)) {
            cfpass.setErrorEnabled(true);
            cfpass.setError("Confirm Password is required");
        } else {
            if (!password.equals(confirmpassword)) {
                Pass.setErrorEnabled(true);
                Pass.setError("Password doesn't match");
            } else {
                isvalidconfirmpassword = true;
            }
        }
        if (TextUtils.isEmpty(mobile)) {
            mobileno.setErrorEnabled(true);
            mobileno.setError("Mobile number is required");
        } else {
            if (mobile.length() < 10) {
                mobileno.setErrorEnabled(true);
                mobileno.setError("Invalid mobile number");
            } else {
                isvalidmobileno = true;
            }
        }
        if (TextUtils.isEmpty(house)) {
            houseno.setErrorEnabled(true);
            houseno.setError("Field cannot be empty");
        } else {
            isvalidhousestreetno = true;
        }
        if (TextUtils.isEmpty(Area)) {
            area.setErrorEnabled(true);
            area.setError("Field cannot be empty");
        } else {
            isvalidarea = true;
        }
        if (TextUtils.isEmpty(Postcode)) {
            postcode.setErrorEnabled(true);
            postcode.setError("Field cannot be empty");
        } else {
            isvalidpostcode = true;
        }

        isvalid = (isValidname && isvalidpostcode && isValidemail && isvalidlname && isvalidconfirmpassword && isvalidpassword && isvalidmobileno && isvalidarea && isvalidhousestreetno) ? true : false;
        return isvalid;
    }
}

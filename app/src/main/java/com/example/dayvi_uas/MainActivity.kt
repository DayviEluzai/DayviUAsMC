package com.example.dayvi_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENTS"
    }

    private var gridLayoutManager: GridLayoutManager? = null
    private var resepList = mutableListOf<DataResep>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        resepList = ArrayList()


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        gridLayoutManager = GridLayoutManager(
            applicationContext, 1,
            LinearLayoutManager.VERTICAL, false
        )

        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView.adapter = ResepAdapter(this, resepList) {
            val intent = Intent(this, Detail::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        prepareresepListData()

    }

    private fun prepareresepListData() {
        var resep = DataResep(
            R.drawable.a,
            "Ayam goreng ketumbar",
            "Bahan-bahan:\n" +
                    "\n" +
                    "1 kg daging ayam (bersihkan, lalu potong-potong)\n" +
                    "4 cm jahe (memarkan)\n" +
                    "minyak goreng secukupnya\n" +
                    "air secukupnya\n" +
                    "Bahan bumbu halus:\n" +
                    "\n" +
                    "5 cm kunyit\n" +
                    "2 sdt ketumbar\n" +
                    "6 siung bawang putih\n" +
                    "2 sdm kaldu ayam\n" +
                    "gula pasir secukupnya\n" +
                    "garam secukupnya\n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Haluskan semua bahan bumbu halus menggunakan blender atau bisa diulek.\n" +
                    "Panaskan minyak goreng, tumis bahan bumbu halus hingga harum. Aduk-aduk terus sampai merata, lalu tuang sedikit air dan masak hingga air mendidih.\n" +
                    "Masukkan satu per satu potongan daging ayam. Tutup dan ungkep daging ayam selama kurang lebih 20 menit. Jika sudah, angkat dan tiriskan.\n" +
                    "Panaskan kembali minyak goreng yang banyak hingga mendidih, masukkan daging ayam yang sudah dibumbui dan goreng sampai berwarna kuning kecokelatan.\n" +
                    "Angkat dan tiriskan. Ayam goreng bumbu ketumbar siap disajikan.",
        )
        resepList.add(resep)
 resep = DataResep(
            R.drawable.b,
            "Ayam rica-rica",
            "Bahan-bahan:\n" +
                    "\n" +
                    "1 ekor ayam (bersihkan, lalu potong-potong)\n" +
                    "3 lembar daun salam\n" +
                    "2 batang serai (geprek)\n" +
                    "sejempol lengkuas (geprek)\n" +
                    "1 ikat kemangi (ambil daunnya saja)\n" +
                    "garam secukupnya\n" +
                    "gula secukupnya\n" +
                    "750 ml air\n" +
                    "Bahan bumbu halus:\n" +
                    "\n" +
                    "8 cabai merah besar\n" +
                    "8 cabai merah keriting\n" +
                    "cabai rawit sesuai selera\n" +
                    "8 bawang merah\n" +
                    "3 bawang putih\n" +
                    "3 kemiri\n" +
                    "1 cm jahe\n" +
                    "1 sdt kunyit bubuk\n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Haluskan semua bahan bumbu halus menggunakan blender atau bisa diulek.\n" +
                    "Panaskan minyak goreng, tumis bahan bumbu halus bersama dengan daun salam, lengkuas, dan serai. Tumis hingga matang dan berubah warna.\n" +
                    "Masukkan ayam dan air sampai ayam terendam. Tambahkan garam dan gula secukupnya, lalu koreksi rasanya.\n" +
                    "Masak hingga ayam matang, air menyusut, dan bumbu menyerap sempurna.\n" +
                    "Sesaat sebelum api dimatikan, masukkan daun kemangi.\n" +
                    "Aduk sebentar, lalu matikan api. Ayam rica-rica siap disajikan.",
        )
        resepList.add(resep)
 resep = DataResep(
            R.drawable.c,
            "Ayam kecap",
            "Bahan-bahan:\n" +
                    "\n" +
                    "1/2 kg ayam (bersihkan, lalu potong-potong)\n" +
                    "1/2 sdm kunyit bubuk\n" +
                    "4 sdm kecap manis\n" +
                    "1 batang daun bawang (iris-iris)\n" +
                    "1 buah tomat (potong-potong)\n" +
                    "6 buah bawang merah (iris tipis)\n" +
                    "4 siung bawang putih (iris tipis)\n" +
                    "8 buah cabai rawit merah (iris tipis)\n" +
                    "2 cm lengkuas (geprek)\n" +
                    "2 cm jahe (geprek)\n" +
                    "1 batang sereh (geprek)\n" +
                    "garam secukupnya\n" +
                    "merica bubuk secukupnya\n" +
                    "kaldu jamur secukupnya\n" +
                    "air secukupnya\n" +
                    "minyak goreng secukupnya\n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Lumuri ayam dengan kunyit bubuk dan garam, diamkan selama kurang lebih 30 menit.\n" +
                    "Panaskan minyak goreng, lalu goreng ayam hingga matang, tetapi jangan terlalu kering. Sisihkan.\n" +
                    "Panaskan kembali sedikit minyak goreng, lalu tumis bawang merah dan bawang putih hingga harum. Setelah itu masukkan sereh, jahe dan lengkuas. Aduk hingga rata.\n" +
                    "Masukkan kecap manis, garam, merica bubuk, kaldu bubuk, dan sedikit air. Aduk kembali hingga rata.\n" +
                    "Masukkan ayam yang telah digoreng, lalu masak hingga kuah mengental. Tambahkan cabai rawit, daun bawang, dan tomat.\n" +
                    "Koreksi rasanya, angkat dan sajikan ayam kecap.",
        )
        resepList.add(resep)
 resep = DataResep(
            R.drawable.d,
            " Ayam teriyaki",
            "Bahan-bahan:\n" +
                    "\n" +
                    "300 gram ayam tanpa tulang (potong dadu)\n" +
                    "100 gram jamur merang\n" +
                    "2 siung bawang putih (cincang)\n" +
                    "1 buah paprika (iris-iris)\n" +
                    "1 butir bawang bombay (cincang)\n" +
                    "2 cm jahe (geprek)\n" +
                    "1 sdm mirin\n" +
                    "3 sdm saus teriyaki\n" +
                    "garam secukupnya\n" +
                    "gula secukupnya\n" +
                    "merica secukupnya\n" +
                    "minyak goreng secukupnya\n" +
                    "air secukupnya\n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Panaskan minyak goreng, tumis bawang putih dan bombay. Setelah itu, masukkan jahe dan paprika. Tumis semua bahan hingga harum.\n" +
                    "Masukkan ayam, lalu aduk hingga tercampur rata dengan bumbu yang telah ditumis.\n" +
                    "Masukkan jamur merang dan mirin. Aduk-aduk sebentar, lalu tambahkan garam, saus teriyaki, merica, dan gula. Aduk semua bahan hingga tercampur rata dan meresap pada daging ayam.\n" +
                    "Setelah itu, tambahkan sedikit air agar bumbu terlihat mengental dan bisa meresap dengan mudah ke daging ayam.\n" +
                    "Tunggu sampai mendidih dan daging ayam menjadi lembut dan matang. Ayam teriyaki siap dihidangkan.",
        )
        resepList.add(resep)
        resep = DataResep(
            R.drawable.e,
            "Ayam yakiniku",
            "Bahan utama:\n" +
                    "\n" +
                    "250 gram ayam filet (bersihkan dan potong memanjang)\n" +
                    "1 bawang bombay (iris-iris)\n" +
                    "1/2 paprika hijau (potong-potong)\n" +
                    "1/2 paprika merah (potong-potong)\n" +
                    "2 bawang putih (cincang)\n" +
                    "1 cm jahe (cincang)\n" +
                    "air secukupnya\n" +
                    "1 sdm maizena (larutkan dengan air)\n" +
                    "garam secukupnya\n" +
                    "gula secukupnya\n" +
                    "Bahan bumbu marinasi:\n" +
                    "\n" +
                    "3 sdm kecap manis\n" +
                    "2 sdm saus tomat\n" +
                    "1 sdm saus tiram\n" +
                    "1 sdm kecap asin\n" +
                    "1/2 sdt lada bubuk\n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Siapkan wadah, campurkan semua bahan bumbu marinasi, lalu aduk merata. Masukkan daging ayam ke dalam bumbu marinasi, lalu aduk kembali hingga rata dan simpan di kulkas selama 30 menit.\n" +
                    "Panaskan minyak goreng, lalu tumis bawang putih dan jahe hingga harum.\n" +
                    "Masukkan daging ayam beserta bumbu marinasi, aduk-aduk hingga ayam berubah warna.\n" +
                    "Masukkan sedikit air, gula, dan garam. Aduk-aduk, lalu koreksi rasa. Masak hingga matang.\n" +
                    "Masukkan larutan maizena, aduk kembali hingga rata.\n" +
                    "Masukkan bawang bombay dan paprika, aduk kembali hingga rata.\n" +
                    "Matikan api, ayam yakiniku siap disajikan.",
        )
        resepList.add(resep)

        resep = DataResep(
            R.drawable.f,
            "Ayam bakar bumbu padang",
            "Bahan-bahan:\n" +
                    "\n" +
                    "150 ml santan\n" +
                    "4 potong paha ayam\n" +
                    "4 lembar daun jeruk\n" +
                    "3 lembar daun salam\n" +
                    "1 lembar daun kunyit\n" +
                    "1 buah air jeruk nipis\n" +
                    "minyak goreng secukupnya\n" +
                    "kaldu bubuk secukupnya\n" +
                    "Bumbu halus:\n" +
                    "\n" +
                    "8 siung bawang merah\n" +
                    "4 siung bawang putih\n" +
                    "4 buah cabai merah\n" +
                    "3 butir kemiri\n" +
                    "2 batang serai, ambil bagian putihnya\n" +
                    "2 ruas lengkuas\n" +
                    "1 cm kunyit\n" +
                    "1,5 sdt ketumbar\n" +
                    "1 ruas jahe\n" +
                    "garam secukupnya\n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Marinasi potongan ayam dengan air jeruk nipis. Diamkan 20 menit.\n" +
                    "Berikutnya, panaskan minyak dan tumis bumbu halus hingga harum.\n" +
                    "Tambahkan daun kunyit, daun salam, dan daun jeruk.\n" +
                    "Masukkan kaldu bubuk dan santan. Aduk merata.\n" +
                    "Masukkan ayam, masak hingga bumbu meresep dan daging empuk.\n" +
                    "Setelah itu, panggang ayam dengan teflon hingga berubah warna. ",
        )
        resepList.add(resep)
        resep = DataResep(
            R.drawable.g,
            "Ayam woku",
            "Bahan-bahan:\n" +
                    "\n" +
                    "1/2 kilogram ayam, potong\n" +
                    "gula pasir secukupnya\n" +
                    "kaldu bubuk secukupnya\n" +
                    "1 sdm air jeruk nipis \n" +
                    "garam secukupnya\n" +
                    "minyak secukupnya\n" +
                    "Bumbu halus:\n" +
                    "\n" +
                    "12 siung bawang merah\n" +
                    "8 buah cabai rawit\n" +
                    "5 siung bawang putih\n" +
                    "4 butir kemiri\n" +
                    "4 buah cabai merah\n" +
                    "3 ruas jahe\n" +
                    "1 ruas kunyit\n" +
                    "Bumbu iris:\n" +
                    "\n" +
                    "5 lembar daun jeruk\n" +
                    "2 batang serai\n" +
                    "2 buah tomat\n" +
                    "1 lembar daun kunyit\n" +
                    "1 batang daun bawang\n" +
                    "daun kemangi secukupnya\n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Marinasi ayam dengan garam dan air perasan jeruk nipis, diamkan beberapa saat.\n" +
                    "Panaskan minyak, tumis bumbu halus dan daun jeruk.\n" +
                    "Tambahkan garam, gula pasir, dan kaldu bubuk secukupnya.\n" +
                    "Masukkan potongan ayam, tuang air sedikit demi sedikit.\n" +
                    "Masukkan bumbu iris, aduk merata, masak hingga air menyusut.\n" +
                    "Masukkan kemangi dan aduk merata. \n" +
                    "Masak ayam woku hingga matang. ",
        )
        resepList.add(resep)
        resep = DataResep(
            R.drawable.h,
            "Ayam panggang taliwang",
            "Bahan-bahan:\n" +
                    "\n" +
                    "1 ekor ayam, potong-potong\n" +
                    "2 sdm kecap manis\n" +
                    "1 sdm gula merah, sisir\n" +
                    "garam secukupnya\n" +
                    "air secukupnya\n" +
                    "minyak secukupnya\n" +
                    "Bumbu halus:\n" +
                    "\n" +
                    "15 buah bawang merah\n" +
                    "10 buah cabai rawit\n" +
                    "10 buah cabai keriting\n" +
                    "7 siung bawang putih\n" +
                    "2 ruas kencur\n" +
                    "1 buah tomat\n" +
                    "1 sdt rebon \n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Panaskan minyak, tumis bumbu halus hingga harum.\n" +
                    "Masukkan ayam, masak sambil diaduk hingga ayam berubah warna. \n" +
                    "Tuang air secukupnya, aduk merata.\n" +
                    "Masukkan gula pasir dan garam.\n" +
                    "Masak hingga ayam empuk dan air menyusut.\n" +
                    "Panggang ayam dengan bumbu hingga kering dan matang. ",
        )
        resepList.add(resep)
        resep = DataResep(
            R.drawable.i,
            "Ayam lodho",
            "Bahan-bahan:\n" +
                    "\n" +
                    "1 kilogram ayam, bersihkan, potong\n" +
                    "500 ml santan kental\n" +
                    "1 buah air jeruk nipis\n" +
                    "10 buah cabai rawit merah\n" +
                    "3 batang serai, geprek\n" +
                    "3 lembar daun salam\n" +
                    "3 lembar daun jeruk\n" +
                    "2 buah jeruk nipis\n" +
                    "1 ruas lengkuas, geprek\n" +
                    "1 sdt jintan bubuk\n" +
                    "garam secukupnya\n" +
                    "gula pasir secukupnya\n" +
                    "minyak secukupnya\n" +
                    "Bumbu halus:\n" +
                    "\n" +
                    "15 siung bawang merah\n" +
                    "7 siung bawang putih\n" +
                    "5 butir kemiri, sangrai\n" +
                    "4 buah cabai merah keriting\n" +
                    "2 ruas kencur\n" +
                    "1 ruas jari kunyit\n" +
                    "1 ruas jahe\n" +
                    "1 sdm ketumbar\n" +
                    "1 sdt lada putih\n" +
                    "air secukupnya\n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Marinasi ayam dengan perasan air jeruk nipis, garam, lada dan sedikit minyak. Aduk semuanya hingga rata.\n" +
                    "Panggang ayam hingga berwarna kecokelatan, lalu angkat.\n" +
                    "Tumis bumbu halus, daun salam, daun jeruk, serai, dan lengkuas.\n" +
                    "Masukkan jintan bubuk dan santan, aduk merata.\n" +
                    "Masukkan ayam, aduk rata dan masak sebentar. \n" +
                    "Beri garam dan gula. Aduk rata dan masak ayam lodho hingga matang. ",
        )
        resepList.add(resep)
        resep = DataResep(
            R.drawable.j,
            "Ayam rica-rica",
            "Bahan-bahan:\n" +
                    "\n" +
                    "1 ekor ayam, potong-potong\n" +
                    "3 lembar daun salam\n" +
                    "2 batang serai, geprek\n" +
                    "1 ruas lengkuas, geprek\n" +
                    "1 ikat daun kemangi\n" +
                    "garam secukupnya\n" +
                    "gula pasir secukupnya\n" +
                    "750 ml air\n" +
                    "minyak secukupnya\n" +
                    "Bumbu halus:\n" +
                    "\n" +
                    "8 buah cabai merah besar\n" +
                    "8 buah cabai merah keriting\n" +
                    "cabai rawit secukupnya\n" +
                    "8 siung bawang merah\n" +
                    "3 siung bawang putih\n" +
                    "3 butir kemiri\n" +
                    "1 cm jahe\n" +
                    "1 sdt kunyit bubuk\n" +
                    "Cara membuat:\n" +
                    "\n" +
                    "Panaskan minyak, tumis bumbu halus dengan daun salam, lengkuas, dan serai.\n" +
                    "Setelah matang, masukkan ayam dan air hingga ayam terendam.\n" +
                    "Beri garam dan gula secukupnya, lalu koreksi rasanya.\n" +
                    "Masak hingga ayam matang, air menyusut, dan bumbu meresap sempurna.\n" +
                    "Terakhir masukkan daun kemangi, aduk sebentar.\n" +
                    "Ayam rica-rica siap disajikan.\n" +
                    "Dari sepuluh resep ayam sederhana di atas, kamu mau masak yang mana dulu, nih? ",
        )
        resepList.add(resep)
    }

}
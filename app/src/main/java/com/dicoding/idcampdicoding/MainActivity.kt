package com.dicoding.idcampdicoding

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var contactAdapter: ContactAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recyclerViewContacts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        contactAdapter = ContactAdapter(this, getDummyContacts())
        recyclerView.adapter = contactAdapter

        val imageViewPerson: ImageView = findViewById(R.id.imageViewPerson)
        imageViewPerson.setOnClickListener {

            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getDummyContacts(): List<Contact> {
        val dummyContacts = mutableListOf<Contact>()

        val names = arrayOf("Diana", "Max", "Lyla", "Tyrone", "Bob", "Dave", "James", "Marco", "Jane", "John")
        val descriptions = arrayOf("Diana adalah seorang psikolog yang memiliki jiwa sosial tinggi. Ia mudah bergaul dan selalu menyapa orang-orang dengan senyum ceria. Diana tidak pernah menyerah dalam menghadapi masalah, ia selalu mencari sisi positif dari segala situasi.",
            "Max adalah seorang tech enthusiast yang menguasai berbagai bidang teknologi. Ia selalu update dengan perkembangan terbaru dan sering diminta menjadi pembicara di berbagai acara. Max juga tidak pelit ilmu, ia senang berbagi pengetahuan dan membantu orang-orang yang kurang paham teknologi.",
            "Lyla adalah seorang pecinta alam yang peduli dengan lingkungan. Ia adalah pendiri organisasi Gaharu yang bergerak di bidang pelestarian hutan. Lyla gemar menanam tanaman di halaman rumahnya dan mengajak tetangga-tetangganya untuk ikut berkebun.",
            "Tyrone adalah seorang artist yang berbakat. Ia mampu menciptakan karya seni yang indah dan unik dengan berbagai media. Tyrone juga memiliki kemampuan luar biasa, ia bisa melukis sambil kayang dengan mata tertutup. Ia sering memamerkan keterampilannya di depan publik dan mendapat tepuk tangan meriah.",
            "Bob adalah seorang musisi indie yang berjiwa rebel. Ia sudah memiliki tiga album yang berisi lagu-lagu ciptaannya sendiri. Lagu-lagunya memiliki lirik yang menyentuh dan musik yang catchy. Bob juga mendapat penghargaan dari majalah Rolling Stones sebagai salah satu dari 100 lagu terbaik.",
            "Dave adalah seorang koki yang profesional. Ia bekerja di restoran hotel mewah di Dubai dan menyajikan hidangan-hidangan lezat yang menggugah selera. Dave tidak sombong meskipun sudah sukses, ia masih bersedia untuk memasak di rumah-rumah pribadi jika diminta. Ia juga suka mencoba resep-resep baru dan mengeksplorasi berbagai bumbu.",
            "James adalah seorang traveler yang suka petualangan. Setiap bulannya, ia berpergian dengan motornya ke tempat-tempat yang jauh dari pemukiman. Ia menikmati pemandangan alam yang indah dan tantangan yang ada di setiap perjalanan. James juga suka berbagi pengalaman dan foto-fotonya di media sosial.",
            "Marco adalah seorang penulis yang produktif. Ia sudah menulis banyak buku yang laris di pasaran. Buku-bukunya memiliki genre yang beragam, mulai dari fiksi, non-fiksi, hingga biografi. Saat ini, ia sedang menulis naskah film yang diadaptasi dari salah satu buku bestsellernya.",
            "Jane adalah seorang mobile developer yang handal. Ia sudah membuat banyak aplikasi yang bermanfaat dan populer. Aplikasi-aplikasinya memiliki desain yang menarik dan fitur yang lengkap. Jane juga tidak segan untuk mengajarkan mengenai mobile development kepada orang-orang yang tertarik.",
            "John adalah seorang business man yang pintar. Ia memiliki banyak usaha yang berkembang dan menguntungkan. Ia juga memiliki kemampuan negosiasi yang hebat, ia bisa mendapatkan deal terbaik dengan cara yang cerdas. John juga suka membantu orang-orang yang ingin berbisnis dengan memberikan saran dan modal.")

        for (i in 0 until 10) {
            dummyContacts.add(
                Contact(
                    names.getOrElse(i) { "Unknown" },
                    "0812-3456-789$i",
                    getProfilePictureResourceId(i + 1),
                    descriptions.getOrElse(i) { "No description available" }
                )
            )
        }
        return dummyContacts
    }

    private fun getProfilePictureResourceId(index: Int): Int {
        return when (index) {
            1 -> R.drawable.profile_picture_1
            2 -> R.drawable.profile_picture_2
            3 -> R.drawable.profile_picture_3
            4 -> R.drawable.profile_picture_4
            5 -> R.drawable.profile_picture_5
            6 -> R.drawable.profile_picture_6
            7 -> R.drawable.profile_picture_7
            8 -> R.drawable.profile_picture_8
            9 -> R.drawable.profile_picture_9
            10 -> R.drawable.profile_picture_10
            else -> R.drawable.dummy_profile_picture
        }
    }

}

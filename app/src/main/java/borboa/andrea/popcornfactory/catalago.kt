package borboa.andrea.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.getSystemService

class catalogo : AppCompatActivity() {

    var adapter: ItemAdapter? = null
    var peliculasAdapter: ItemAdapter?= null
    var seriesAdapter:ItemAdapter? = null
    var peliculas = ArrayList<Pelicula>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalago)

        cargarItems()

        peliculasAdapter = ItemAdapter(this, peliculas)


        var gridView_movies:GridView = findViewById(R.id.gridview) as GridView


        gridView_movies.adapter = peliculasAdapter


    }

    fun cargarItems():Unit{
        peliculas.add(Pelicula("Big Hero 6", R.drawable.bigherosix, R.drawable.headerbigherosix, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called \"Big Hero 6\"."))
        peliculas.add(Pelicula("1917", R.drawable.milnovecientosdiecisiete, R.drawable.milnovecientosdiecisieteheader, "British trenches somewhere in France. World war has been going on for the third year, heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly, sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two young soldiers, Blake and Schofield, are summoned to the general, who instructs them to send an important message to Colonel MacKenzie in the Second Devonshire Battalion, whose telephone connection was cut off by the enemy."))
        peliculas.add(Pelicula("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        peliculas.add(Pelicula("Men in Black", R.drawable.mib, R.drawable.mibheader, "Based off of the comic book. Unbeknownst to other people, there is a private agency code named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then, one of the agency\'s finest men only going by the name \"K\" (Tommy Lee Jones), is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the \"Bug\" race. He takes the body of a farmer (Vincent D\'Onofrio) and heads to New York. He is searching for a super energy source called \"The Galaxy\". Now, Agents J and K must stop the bug before it can escape with the galaxy."))
        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the \'secret life of toys\' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody\'s place as Andy\'s favorite toy, Woody doesn\'t like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home."))
        peliculas.add(Pelicula("Inception", R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb\'s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."))

    }

    class ItemAdapter:BaseAdapter{

        var contexto:Context? = null
        var items = ArrayList<Pelicula>()

        constructor(contexto:Context, items:ArrayList<Pelicula>){
            this.contexto = contexto
            this.items = items
        }

        override fun getCount(): Int {
            return this.items.size
        }

        override fun getItem(position: Int): Any {
            return items[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var item = items[position]
            var inflator = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.pelicula, null)

            var image:ImageView = vista.findViewById(R.id.iv_pelicula) as ImageView
            var title:TextView = vista.findViewById(R.id.iv_titulo) as TextView


            image.setImageResource(item.image)
            title.setText(item.titulo)

            image.setOnClickListener{
                var intent = Intent(contexto, detalle_pelicula::class.java)
                intent.putExtra("title",item.titulo)
                intent.putExtra("image",item.image)
                intent.putExtra("sinopsis",item.sinopsis)
                intent.putExtra("header",item.header)
                contexto!!.startActivity(intent)
            }

            return vista

        }

    }

}
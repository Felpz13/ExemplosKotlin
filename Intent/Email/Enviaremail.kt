import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity

fun enviarEmail()
{
    val email = Intent (Intent.ACTION_SEND)
    email.putExtra(Intent.EXTRA_EMAIL, arrayOf("felipeclaro@mail.com"))
    email.putExtra(Intent.EXTRA_SUBJECT, "Contato - Curriculo")

    email.type = "message/rfc822" //"vnd.android.cursor.dir/email"

    startActivity(Intent.createChooser(email, "Escolha o aplicativo:"))
}

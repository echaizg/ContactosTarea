package apps.cursos.com.contactostarea;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    TextInputEditText txtnombreCompleto ;
    TextInputEditText txtfechaNacimiento ;
    TextInputEditText txttelefono ;
    TextInputEditText txtemail ;
    TextInputEditText txtdescripcionContacto ;

    String str_nombre,str_fecha, str_telefono,str_email,str_descripcion;
    Button btnEditarDatos;

    public static String EXTRA_NOMBRE= "NombreCompleto";
    public static String EXTRA_NACIMIENTO= "FechaNacimiento";
    public static String EXTRA_TELEFONO= "Telefono";
    public static String EXTRA_EMAIL= "Email";
    public static String EXTRA_DESCRIPCION= "DescripcionContacto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        txtnombreCompleto        = (TextInputEditText)  findViewById(R.id.lb_nombre_completo);
        txtfechaNacimiento       = (TextInputEditText)  findViewById(R.id.lb_fecha_nacimiento);
        txttelefono              = (TextInputEditText)  findViewById(R.id.lb_telefono);
        txtemail                 = (TextInputEditText)  findViewById(R.id.lb_email);
        txtdescripcionContacto   = (TextInputEditText)  findViewById(R.id.lb_descripcion_contacto);

        btnEditarDatos        =(Button) findViewById(R.id.btn_editar_datos);
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra(EXTRA_NOMBRE,str_nombre);
                i.putExtra(EXTRA_NACIMIENTO,str_fecha);
                i.putExtra(EXTRA_TELEFONO,str_telefono);
                i.putExtra(EXTRA_EMAIL,str_email);
                i.putExtra(EXTRA_DESCRIPCION,str_descripcion);
                startActivity(i);
                finish();
            }
        });


      Bundle parametros = getIntent().getExtras();

         str_nombre = parametros.getString(SegundaActivity.EXTRA_NOMBRE);
        str_fecha = parametros.getString(SegundaActivity.EXTRA_NACIMIENTO);
        str_telefono = parametros.getString(SegundaActivity.EXTRA_TELEFONO);
        str_email = parametros.getString(SegundaActivity.EXTRA_EMAIL);
        str_descripcion = parametros.getString(SegundaActivity.EXTRA_DESCRIPCION);

        txtnombreCompleto.setText(str_nombre);
        txtfechaNacimiento.setText(getString(R.string.hint_fecha_nacimiento) + " : " + str_fecha);
        txttelefono.setText(getString(R.string.hint_telefono) + ". " + str_telefono);
        txtemail.setText(getString(R.string.hint_email) + " : " + str_email);
        txtdescripcionContacto.setText(getString(R.string.hint_descripcion_contacto )+ " : " + str_descripcion);












    }

}

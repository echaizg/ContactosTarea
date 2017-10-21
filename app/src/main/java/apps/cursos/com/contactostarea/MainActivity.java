package apps.cursos.com.contactostarea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity{

    TextInputEditText txtnombreCompleto ;
    TextInputEditText txtfechaNacimiento ;
    TextInputEditText txttelefono ;
    TextInputEditText txtemail ;
    TextInputEditText txtdescripcionContacto ;

    public static String EXTRA_NOMBRE= "NombreCompleto";
    public static String EXTRA_NACIMIENTO= "FechaNacimiento";
    public static String EXTRA_TELEFONO= "Telefono";
    public static String EXTRA_EMAIL= "Email";
    public static String EXTRA_DESCRIPCION= "DescripcionContacto";



    Button btnSiguiente;
    Button btnCancelar;
    Button btnOk;

    DatePicker dtFecha;
    private  int dia, mes, año;

    Calendar calendario ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombreCompleto        = (TextInputEditText)  findViewById(R.id.txilNombreCompleto);
        txtfechaNacimiento       = (TextInputEditText)  findViewById(R.id.txilFechaNacimiento);
        txttelefono              = (TextInputEditText)  findViewById(R.id.txilTelefono);
        txtemail                 = (TextInputEditText)  findViewById(R.id.txilEmail);
        txtdescripcionContacto   = (TextInputEditText)  findViewById(R.id.txilDescripcionContacto);



        dtFecha                  = (DatePicker)  findViewById(R.id.datePicker);
        dtFecha.init(1990, 1, 1, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        dia = dtFecha.getDayOfMonth();
                        mes = dtFecha.getMonth();
                        año = dtFecha.getYear();
                        calendario = Calendar.getInstance();
                        calendario.set(año,mes,dia);
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        txtfechaNacimiento.setText(format.format(calendario.getTime()));
                    }
                });
                txtfechaNacimiento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {

                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(txtfechaNacimiento.getWindowToken(), 0);
                        }
                    }
                });



        btnCancelar        =(Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtfechaNacimiento.setText("");
            }
        });


        btnOk              =(Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dia = dtFecha.getDayOfMonth();
                mes = dtFecha.getMonth();
                año = dtFecha.getYear();
                 calendario = Calendar.getInstance();
                calendario.set(año,mes,dia);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                txtfechaNacimiento.setText(format.format(calendario.getTime()));
                txttelefono.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(txttelefono, InputMethodManager.SHOW_IMPLICIT);
               ;
            }
        });





        btnSiguiente        =(Button) findViewById(R.id.btn_siguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SegundaActivity.class);
                i.putExtra(EXTRA_NOMBRE,txtnombreCompleto.getText().toString());
                i.putExtra(EXTRA_NACIMIENTO,txtfechaNacimiento.getText().toString());
                i.putExtra(EXTRA_TELEFONO,txttelefono.getText().toString());
                i.putExtra(EXTRA_EMAIL,txtemail.getText().toString());
                i.putExtra(EXTRA_DESCRIPCION,txtdescripcionContacto.getText().toString());
                startActivity(i);
                finish();
            }
        });



        if (this.getIntent().getExtras() != null ) {

        Bundle parametros = getIntent().getExtras();

        txtnombreCompleto.setText(parametros.getString(MainActivity.EXTRA_NOMBRE));
        txtfechaNacimiento.setText(parametros.getString(MainActivity.EXTRA_NACIMIENTO));
        txttelefono.setText(parametros.getString(MainActivity.EXTRA_TELEFONO));
        txtemail.setText(parametros.getString(MainActivity.EXTRA_EMAIL));
        txtdescripcionContacto.setText(parametros.getString(MainActivity.EXTRA_DESCRIPCION));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date convertedDate ;


            try {
                convertedDate = formato.parse(txtfechaNacimiento.getText().toString());
                calendario = Calendar.getInstance();
                calendario.setTime(convertedDate);

                dtFecha.init(calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        dia = dtFecha.getDayOfMonth();
                        mes = dtFecha.getMonth();
                        año = dtFecha.getYear();
                        calendario = Calendar.getInstance();
                        calendario.set(año,mes,dia);
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        txtfechaNacimiento.setText(format.format(calendario.getTime()));
                    }
                });
                System.out.println(convertedDate.getMonth());
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }




        }





    }




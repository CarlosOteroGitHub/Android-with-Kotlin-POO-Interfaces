package com.example.myapplicationkootlin

/*

Author: Ing. Carlos Otero Ramírez

 */

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , View.OnClickListener {

    var suma_objeto = Suma();
    var resta_objeto = Resta();

    var num1:Double = 0.0;
    var num2:Double = 0.0;

    private var editText1:EditText ?= null;
    private var editText2:EditText ?= null;

    private var button1:Button ?= null;
    private var button2:Button ?= null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setTitle("Interfaces");

        editText1 = findViewById(R.id.AM1_id2);
        editText2 = findViewById(R.id.AM1_id4);

        button1 = findViewById(R.id.AM1_id5);
        button1!!.setOnClickListener(this);

        button2 = findViewById(R.id.AM1_id6);
        button2!!.setOnClickListener(this);
    }

    fun dialogoAlerta(view: View?, mensaje: String){
        val builder = AlertDialog.Builder(this);
        builder.setTitle("Mensaje Informativo!");
        builder.setMessage(mensaje);
        builder.show();
    }

    override fun onClick(v: View?){
        when(v?.id) {
            R.id.AM1_id5 ->
                if(editText1?.text.toString().isEmpty() && editText2?.text.toString().isEmpty()) {
                    dialogoAlerta(null, "Los campos de texto están vacios");
                } else if(editText1?.text.toString().isEmpty() || editText2?.text.toString().isEmpty()){
                    dialogoAlerta( null, "Uno de los campos de texto está vacio");
                } else {
                    num1 = editText1?.text.toString().toDouble();
                    num2 = editText2?.text.toString().toDouble();

                    dialogoAlerta(null, "La suma de la operación es: " + suma_objeto.operacionMatematica(num1, num2));
                    dialogoAlerta(null, "La resta de la operación es: " + resta_objeto.operacionMatematica(num1, num2));
                }
            R.id.AM1_id6 ->
                System.exit(0);
        }
    }
}
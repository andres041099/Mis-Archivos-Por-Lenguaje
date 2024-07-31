/* Nombre Andres Rodriguez Liberato
   matricula:100520391 
   sección:n1
   Asignatura:inf 510
*/

#include<iostream>
#include<fstream>
#include<string.h>
#include<stdlib.h>

using  namespace std;

int main(){
    int codigo,opc,bccodigo,ncodigo;
	string nom, nnom;
	string tel1, ntlf1;
	string tel2, ntlf2;
	string email, nemail;
	string direccion, ndireccion;
	ofstream ag;
	ifstream le;
	ifstream le2;
	ifstream le3;
	ofstream temp;
	string acm;
	ag.open("Agenda.txt", ios::app);
	le2.open("Acerca de mi.txt", ios::in);
	
	    cout<<"::::::::Agenda:::::::"<<endl;
	     cout<<":::::Menu de agenda:::::"<<endl;
	    cout<<"1 Crear contacto"<<endl;
		cout<<"2 Modificar contacto"<<endl;
		cout<<"3 Consultar contacto"<<endl;
		cout<<"4 Eliminar contacto"<<endl;
		cout<<"5 Listar contactos"<<endl;
		cout<<"6 Acerca de mi"<<endl;
		cout<<"7 Salir"<<endl;
		cout<<endl;
		cout<<"Elija una opcion:"<<endl;
		cin>>opc;	
		
		switch(opc){  
		
		case 1: 
		system("cls");
		cout<<"Ingrese su Nombre: "<<endl;
		cin>>nom;
		cout<<"Ingrese su Numero Telefonico: "<<endl;
		cin>>tel1;
		cout<<"Ingrese su Numero Celular: "<<endl;
		cin>>tel2;
		cout<<"Ingrese su Email: "<<endl;
		cin>>email;
		cout<<"Ingrese su Direccion: "<<endl;
		cin>>direccion;
		cout<<"Ingrese su codigo: "<<endl;
		cin>>codigo;
		ag<<nom<<" "<<tel1 <<" " <<tel2<<" " <<email<<" " <<direccion<<" " <<codigo<<endl;
		cout<<"su agenda es: "<<endl;
	    cout << "------------------------\n";
		cout<<" Nombre: "<<nom<<endl;
		cout<<"Telefono: "<<tel1<<endl;
		cout<<"Celular: "<<tel2<<endl;
		cout<<"Email: "<<email<<endl;
		cout<<"Direccion: "<<direccion<<endl;
		cout<<"Codigo: "<<codigo<<endl;
		cout<<"Esta guardado en su Agenda.txt "<<endl;
		break;
		case 2:
			 system("cls");  
                    le.open("Agenda.txt");
                    temp.open("Temp.txt");
                    le>>nom>>tel1>>tel2>>email>>direccion>>codigo;
                    bool encontrado=false;
                    cout<<"Ingrese Codigo a modificar: "<<endl;
                    cin>>bccodigo;
                    while(!le.eof())
                    {
                        le>>bccodigo;
                        if(codigo==bccodigo)
                        {
                            encontrado=true;
                            cout<<"Ingrese su Nombre a modificar: "<<endl;
                            cin>>nnom;
                            cout<<"Ingrese nuevo numero de telefono: "<<endl;
                            cin>>ntlf1;
                            cout<<"Ingrese nuevo numero  celular: "<<endl;
                            cin>>ntlf2;
                            cout<<"Ingrese nuevo email: "<<endl;
                            cin>>nemail;
                            cout<<"Ingrese nueva direccion: "<<endl;
                            cin>>ndireccion;
                            cout<<"Ingrese nuevo codigo: "<<endl;
                            cin>>ncodigo;
                            temp<<nnom<<" "<<ntlf1<<" "<<ntlf2<<" "<<nemail<<" "<<ndireccion<<" "<<ncodigo<<endl;
                            cout<<endl;
                            cout<<"Nuevo contacto modificado"<<endl;
                            
                        }
                        else
                        {
                            temp<<nnom<<" "<<ntlf1<<" "<<ntlf2<<" "<<nemail<<" "<<ndireccion<<" "<<ncodigo<<endl;
                        }
                        le>>nom>>tel1>>tel2>>email>>direccion>>codigo;
                    }
                    if(encontrado==false)
                    {
                        cout<<"Codigo no encontrado"<<endl;
                    }
                    le.close();
                    temp.close();
                    remove("Agenda.txt");
                    rename("Temp.txt","Agenda.txt");
                    break;
	
}
switch(opc){
	case 3:
		system("cls");  
                    le.open("Agenda.txt");
                    le>>nom>>tel1>>tel2>>email>>direccion>>codigo;
                    bool encontrado=false;
                    cout<<"Ingrese Codigo para consultar: "<<endl;
                    cin>>bccodigo;
                    while(!le.eof())
                    {
                        le>>codigo;
                        if(codigo==bccodigo)
                        {
                            encontrado=true;
                            cout<<"Consulta es:"<<endl;
                            cout<<" Nombre: "<<nom<<endl;
							cout<<"Telefono: "<<tel1<<endl;
							cout<<"Celular: "<<tel2<<endl;
							cout<<"Email: "<<email<<endl;
							cout<<"Direccion: "<<direccion<<endl;
							cout<<"Codigo: "<<codigo<<endl;
                            cout<<"----------------------------"<<endl;
                            cout<<endl;
                        }
                        le>>nom>>tel1>>tel2>>email>>direccion>>codigo;
                    }
                    if(encontrado==false)
                    {
                        cout<<"Codigo  no encontrado"<<endl;
                    }
                    le.close();
                    break;
                
		
		
	
}
switch(opc){
	case 4:
		
		            system("cls");
                    le.open("Agenda.txt");
                    temp.open("Temp.txt");
                    le>>nom>>tel1>>tel2>>email>>direccion>>codigo;
                    bool encontrado=false;
                    cout<<"Ingrese codigo a eliminar: "<<endl;
                    cin>>bccodigo;
                    while(!le.eof())
                    {
                        le>>codigo;
                        if(codigo==bccodigo)
                        {
                            encontrado=true;
                            cout<<" Nombre: "<<nom<<endl;
							cout<<"Telefono: "<<tel1<<endl;
							cout<<"Celular: "<<tel2<<endl;
							cout<<"Email: "<<email<<endl;
							cout<<"Direccion: "<<direccion<<endl;
							cout<<"Codigo: "<<codigo<<endl;
                            cout<<endl;
                            cout<<"Eliminado"<<endl;
                        }
                        else
                        {
                           temp<<nom<<" "<<tel1 <<" " <<tel2<<" " <<email<<" " <<direccion<<" " <<codigo<<endl;
                        }
                       temp<<nnom<<" "<<tel1 <<" " <<tel2<<" " <<email<<" " <<direccion<<" " <<codigo<<endl;
                    }
                    if(encontrado==false)
                    {
                        cout<<"Codigo no encontrada"<<endl;
                    }
                    le.close();
                    temp.close();
                    remove("Agenda.txt");
                    rename("Temp.txt","Agenda.txt");

                    break;
			
			
}
switch(opc){
	case 5:
		system("cls");  
                    le.open("Agenda.txt");
                    le>>nom>>tel1>>tel2>>email>>direccion>>codigo;
                    bool encontrado=false;
                    cout<<"Ingrese Codigo para la listas de contactos: "<<endl;
                    cin>>bccodigo;
                    while(!le.eof())
                    {
                        le>>codigo;
                        if(codigo==bccodigo)
                        {
                            encontrado=true;
                            cout<<"Lista de contactos es: "<<endl;
                            cout<<" Nombre: "<<nom<<endl;
							cout<<"Telefono: "<<tel1<<endl;
							cout<<"Celular: "<<tel2<<endl;
							cout<<"Email: "<<email<<endl;
							cout<<"Direccion: "<<direccion<<endl;
							cout<<"Codigo: "<<codigo<<endl;
                            cout<<"----------------------------"<<endl;
                            cout<<endl;
                        }
                        le>>nom>>tel1>>tel2>>email>>direccion>>codigo;
                    }
                    if(encontrado==false)
                    {
                        cout<<"Codigo  no encontrado"<<endl;
                    }
                    le.close();
                    break;
                

}
switch(opc){
	case 6:
		system("cls");
		    while(!le2.eof()){
			getline(le2, acm);
			cout<<acm<<endl;
			}
        break;
	
	case 7:
		system("cls");

                    break;
}


     
	
	    
		
	
	
	system("pause");
return 0;

}


#include <iostream>
#include <esconu.h>

using namespace std;

class Electrodomestico
{
    private: 
        string nombre, modelo;
        double consumoElectrico;
    public:
        Electrodomestico ();
        void setElectrodomestico();
        void getNombre();
        void getModelo();
        void getConsumo();
};

class Televisor : public Electrodomestico
{
    private:
        double pulgadas;
    public:
        Televisor();
        void setTelevisor();
        void getDatosDeTelevisor();
};

Televisor :: Televisor (){};

void Televisor :: setTelevisor() 
{
    double NuevaPulgadas;
    setElectrodomestico();
    cout << "ingrese las pulgadas del televisor" ;
    cin>>NuevaPulgadas;

    pulgadas = NuevaPulgadas;

}

void Televisor:: getDatosDeTelevisor() 
{   
    getNombre();
    getModelo();
    getConsumo();
    cout << "pulgadas del televisor: " << pulgadas << endl;

}



Electrodomestico :: Electrodomestico(){}

void Electrodomestico::setElectrodomestico()
{
    
    string nuevoNombre,nuevoModelo;
    double nuevoConsumoElectrico;
    cout << "Dijite los datos del electrodomestico que quiere registrar: " << endl;
    cout << "Nombre del Electrodomestico: "; 
    cin>> nuevoNombre;
    cout <<"Modelo de " << nuevoNombre <<": ";
    cin>> nuevoModelo;
    cout << "Consumo Electrico En Voltios de: " << nuevoNombre << ", modelo: " <<nuevoModelo << " es de: ";
    cin>> nuevoConsumoElectrico;

    nombre = nuevoNombre;
    modelo = nuevoModelo;
    consumoElectrico = nuevoConsumoElectrico;

} 

void Electrodomestico::getNombre()
{
    BorraPantalla();
    cout <<"El nombre del articulo es: " << nombre << endl; 
}

void Electrodomestico::getModelo()
{

    cout <<"El modelo del articulo es: " << modelo << endl; 
}

void Electrodomestico::getConsumo()
{

    cout << "su consumo electrico en voltio es: " << consumoElectrico <<" V" <<endl;
}



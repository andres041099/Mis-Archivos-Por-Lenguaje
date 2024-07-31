#include <iostream>
#include <esconu.h>
#include "Electrodimestico.h"

using namespace std;


int main()
{
    BorraPantalla();
    ColorTexto(CIAN);
    Electrodomestico electrodomestico1;
    electrodomestico1.setElectrodomestico();
    BorraPantalla();
    electrodomestico1.getNombre();
    electrodomestico1.getModelo();
    electrodomestico1.getConsumo();
    TeclaPresionada("Preciona una tecla para continuar");
    BorraPantalla();
    ColorTexto(ROJOCLARO);
    cout << "Ahora vamos a agregar una Televisor" << endl;
    TeclaPresionada("Preciona una tecla para continuar");
    ColorTexto(AMARILLO);
    BorraPantalla();
    CoordenadaXY (16, 1); 
    cout << "TELEVISOR " << endl;
    Televisor television;
    television.setTelevisor();
    television.getDatosDeTelevisor();
    TeclaPresionada("Preciona una tecla para continuar");
    BorraPantalla();
    cout << "Gracias por utilizar este Tutorial, Ejemplo de como se ejecutan las herencias" << endl;
    TeclaPresionada("preciona cualquier tecla para salir");

    cout << endl  << endl;

    return 0;
}
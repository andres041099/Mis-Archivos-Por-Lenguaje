/*Asignacion dinamica de arreglos 

new: reserva el numero de bytes solicitados por la declaracion
delete: libera un bloque de bytes reservados con anterioridad

Ejemplo: pedir al usuario n calificaciones y almacenarlos en un arrreglo dinamoco
*/

#include<iostream>
#include<conio.h>
#include<stdlib.h> //con esta libreria es que funciona new y delete
using namespace std;

// Prototipo de Funcion
 
void pedirNotas();
void mostrarNotas();

int numCalif,*calif;

int main(){
	pedirNotas();
	mostrarNotas();
	
	delete[] calif; //Liberando el espacio en bytes utilizados anteriormente 
	
	getch();
	return 0;
}

void pedirNotas(){
     cout<<"Digite el numero de calificaciones: ";
     cin>>numCalif;
     
calif = new int[numCalif]; //Crear el arreglo

for(int i=0;i<numCalif;i++){
	cout<<"Ingrese una nota: ";
	cin>>calif[i];
    }
}

void mostrarNotas(){
	cout<<"\n\nMostrando Notas del usuario:\n";
	for(int i=0;i<numCalif;i++){
		cout<<calif[i]<<endl;
		
		
	}


}



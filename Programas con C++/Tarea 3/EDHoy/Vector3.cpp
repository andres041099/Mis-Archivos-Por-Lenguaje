//
//  main.cpp
//  Vector 3
//
//  Created by Andrés Enrique Linares Félix on 24/09/12.
//  Copyright (c) 2012 Andrés Enrique Linares Félix. All rights reserved.
//

#include <vector>
#include <iostream>
#include <esconu.h>

using namespace std;
int main ()
{
    BorraPantalla();
    
    vector<int> v1;       // declaración de un vector inicializado con una lista.
	vector<int>::iterator iterador;    // declaracion de un iterador.
    v1.push_back(5);
    v1.push_back(20);
    v1.push_back(16);
    v1.push_back(4);
    v1.push_back(9);
    v1.push_back(25);
    v1.push_back(14);
    v1.push_back(8);
    v1.push_back(100);
    v1.push_back(88);
    v1.push_back(11);
    v1.push_back(39);
    v1.push_back(41);
    v1.push_back(9);
    
	cout << endl << "El contenido actual del v1 es: " << endl << endl;
    
    
	iterador = v1.begin();       // begin() retorna un puntero al primer elemento
	while ( iterador != v1.end() )
	{
		cout << *iterador << endl;   // el iterator puede ser "desreferenciado"
		iterador++;                  // el iterator puede ser incrementado
	}
    
    
    

    v1.pop_back();
    v1.pop_back();
    
    cout << endl << "El contenido actual del v1 es: " << endl << endl;
    
    iterador = v1.begin();       // begin() retorna un puntero al primer elemento
    while ( iterador != v1.end() )
    {
        cout << *iterador << endl;   // el iterator puede ser "desreferenciado"
        iterador++;                  // el iterator puede ser incrementado
    }
    
    
	return 0;
}

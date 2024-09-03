//
//  main.cpp
//  Vector1
//
//  Created by Andrés Enrique Linares Félix on 24/09/12.
//  Copyright (c) 2012 Andrés Enrique Linares Félix. All rights reserved.
//

#include <vector>
#include <iostream>
#include <esconu.h>


using namespace std;

int main()
{
    BorraPantalla();
    vector<int> numeros;   // Contenedor de vector de números enteros.
    
    for (int i = 1; i <= 6; ++i)  // Añade los números del 1 al 6 al vector.
    {
        numeros.push_back(i);
    }
    
    
    // Imprime el contendido del vector separando cada elemento por un espacio.
    
    numeros.pop_back();
    
    for (int i = 0; i < numeros.size(); i++)
    {
        cout << numeros[i] << ' ';
    }
    
    cout << endl;
    
    
    return 0;
}

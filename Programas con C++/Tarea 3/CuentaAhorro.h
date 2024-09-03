//
//  Header.h
//  Cuenta Ahorro
//
//  Created by Andrés Enrique Linares Félix on 15/09/12.
//  Copyright (c) 2012 Andrés Enrique Linares Félix. All rights reserved.
//

#ifndef Cuenta_Ahorro_Header_h
#define Cuenta_Ahorro_Header_h

#include "CuentaBancaria.h"

using namespace std;

class CuentaAhorro : public CuentaBancaria
{
protected:
    
    double interesAcumulado;                                                 // interes acumyulado de la cuenta
    
public:
    
    CuentaAhorro(double balanceInicial) : CuentaBancaria (balanceInicial),
                                          interesAcumulado(0.00) {}          // constructor
    
    
    void interes(float tasa)                                                 // hace agrega interés
    {
        interesAcumulado += balance * (tasa / 100);
        balance += balance * (tasa / 100);
    }

};  //fin de la clase CuentaAhorro

#endif

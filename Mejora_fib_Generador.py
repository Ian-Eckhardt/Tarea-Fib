from typing import Generator

def fibGen(n: int) -> Generator[int, None, None]:
    if n < 0:
        raise ValueError("El índice debe ser un número entero no negativo.")
    yield 0
    if n > 0:
        yield 1
    penultimo: int = 0
    ultimo:    int = 1
    for _ in range(1, n):
        penultimo, ultimo = ultimo, penultimo + ultimo
        yield ultimo

if __name__ == "__main__":
    n = int(input("¿Fibonacci hasta la posición?: "))
    try:
        for i in fibGen(n):    
            print(i)
    except ValueError as e:
        print("Error:", e)

"""
Eckhardt Alvarez Ian
Cambios: Correción de errores si se pone un número negativo en el input
"""

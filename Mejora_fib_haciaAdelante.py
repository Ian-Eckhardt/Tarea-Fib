def fibAdel(n: int) -> int:
    if n < 0:
        raise ValueError("El índice debe ser un número entero no negativo.")
    if n < 2:
        return n

    penultimo: int = 0
    ultimo:    int = 1
    for _ in range(2, n + 1):
        penultimo, ultimo = ultimo, penultimo + ultimo
    return ultimo


if __name__ == "__main__":
    try:
        n = int(input("¿De qué posición quieres el valor de Fibonacci?: "))
        print(f"El {n}-ésimo valor de Fibonacci es: {fibAdel(n)}")
    except ValueError as e:
        print("Error:", e)

"""
Eckhardt Alvarez Ian. 12/11/2025
Cambios: solucionar error si se pone negativo como input.
"""

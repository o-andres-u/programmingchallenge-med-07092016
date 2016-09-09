package challenge2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class CombinacionGrupos {
  public static int[][] nivel1_dividirGrupo(int[] numeros) {
    int numeroGrupos = 2;

    // Se verifica si es posible su combinación con la suma dividida con los números de elementos.
    int sumaTotal = calcularSumaArreglo(numeros);
    if (sumaTotal % numeroGrupos != 0) {
      return null;
    }
    int sumaNecesariaGrupo = sumaTotal / numeroGrupos;

    // Se ordenan
    Arrays.sort(numeros);

    Stack<Integer> pilaIndicesGrupo1 = new Stack<>();
    int indiceActual = numeros.length - 1;
    int sumaGrupoActual = 0;
    // Se validan los indices necesarios para el grupo y asi obtener la suma necesaria del grupo
    while (indiceActual >= 0) {
      pilaIndicesGrupo1.push(indiceActual);
      sumaGrupoActual += numeros[indiceActual];
      if (sumaGrupoActual > sumaNecesariaGrupo) {
        indiceActual = pilaIndicesGrupo1.pop();
        sumaGrupoActual -= numeros[indiceActual];
      } else if (sumaGrupoActual == sumaNecesariaGrupo) {
        break;
      }
      indiceActual--;
    }

    // No encontró posibilidad
    if (indiceActual == -1) {
      return null;
    }

    // Se obtienen los valores del grupo 1
    int[] grupo1 = new int[pilaIndicesGrupo1.size()];
    for (int indiceGrupo = 0; indiceGrupo < grupo1.length; indiceGrupo++) {
      grupo1[indiceGrupo] = numeros[pilaIndicesGrupo1.get(indiceGrupo)];
    }

    // Se obtienen los valores del grupo 2
    ArrayList<Integer> pilaIndicesGrupo2 = new ArrayList<>(numeros.length);
    for (int i = 0; i < numeros.length; i++) {
      pilaIndicesGrupo2.add(i);
    }
    pilaIndicesGrupo2.removeAll(pilaIndicesGrupo1);
    int[] grupo2 = new int[pilaIndicesGrupo2.size()];
    for (int indiceGrupo = 0; indiceGrupo < grupo2.length; indiceGrupo++) {
      grupo2[indiceGrupo] = numeros[pilaIndicesGrupo2.get(indiceGrupo)];
    }

    return new int[][] { grupo1, grupo2 };
  }

  public static int[][] nivel2_dividirGrupo(int[] numeros) {
    int numeroGrupos = 2;

    // Se verifica si es posible su combinación con la suma dividida con los números de elementos.
    int sumaTotal = calcularSumaArreglo(numeros);
    if (sumaTotal % numeroGrupos != 0) {
      return null;
    }
    int sumaNecesariaGrupo = sumaTotal / numeroGrupos;

    // Se ordenan
    Arrays.sort(numeros);

    Stack<Integer> pilaIndicesGrupo1 = new Stack<>();
    int indiceActual = numeros.length - 1;
    int sumaGrupoActual = 0;
    // Se validan los indices necesarios para el grupo y asi obtener la suma necesaria del grupo
    while (indiceActual >= 0) {
      pilaIndicesGrupo1.push(indiceActual);
      sumaGrupoActual += numeros[indiceActual];
      if (sumaGrupoActual > sumaNecesariaGrupo) {
        indiceActual = pilaIndicesGrupo1.pop();
        sumaGrupoActual -= numeros[indiceActual];
      } else if (sumaGrupoActual == sumaNecesariaGrupo) {
        break;
      }
      indiceActual--;
    }

    // No encontró posibilidad
    if (indiceActual == -1) {
      return null;
    }

    // Se obtienen los valores del grupo 1
    int[] grupo1 = new int[pilaIndicesGrupo1.size()];
    for (int indiceGrupo = 0; indiceGrupo < grupo1.length; indiceGrupo++) {
      grupo1[indiceGrupo] = numeros[pilaIndicesGrupo1.get(indiceGrupo)];
    }

    // Se obtienen los valores del grupo 2
    ArrayList<Integer> pilaIndicesGrupo2 = new ArrayList<>(numeros.length);
    for (int i = 0; i < numeros.length; i++) {
      pilaIndicesGrupo2.add(i);
    }
    pilaIndicesGrupo2.removeAll(pilaIndicesGrupo1);
    int[] grupo2 = new int[pilaIndicesGrupo2.size()];
    for (int indiceGrupo = 0; indiceGrupo < grupo2.length; indiceGrupo++) {
      grupo2[indiceGrupo] = numeros[pilaIndicesGrupo2.get(indiceGrupo)];
    }

    return new int[][] { grupo1, grupo2 };
  }

  public static int[][] nivel3_dividirGrupo(int[] numeros, int numeroGrupos) {
    // Se verifica si es posible su combinación con la suma dividida con los números de elementos.
    int sumaTotal = calcularSumaArreglo(numeros);
    if (sumaTotal % numeroGrupos != 0) {
      return null;
    }
    int sumaNecesariaGrupo = sumaTotal / numeroGrupos;

    // Se ordenan
    Arrays.sort(numeros);

    // Se obtienen los valores del grupo
    ArrayList<Integer> indicesDisponiblesList = new ArrayList<>(numeros.length);
    for (int i = 0; i < numeros.length; i++) {
      indicesDisponiblesList.add(i);
    }

    int[][] grupos = new int[numeroGrupos][];
    int gruposEncontrados = 0;

    while (gruposEncontrados < numeroGrupos ) {
      Stack<Integer> pilaIndicesGrupo = new Stack<>();
      int indiceActual = numeros.length - 1;
      int sumaGrupoActual = 0;
      // Se validan los indices necesarios para el grupo y asi obtener la suma necesaria del grupo
      while (indiceActual >= 0) {
        if (indicesDisponiblesList.contains(indiceActual)) {
          pilaIndicesGrupo.push(indiceActual);
          sumaGrupoActual += numeros[indiceActual];
          if (sumaGrupoActual > sumaNecesariaGrupo) {
            indiceActual = pilaIndicesGrupo.pop();
            sumaGrupoActual -= numeros[indiceActual];
          } else if (sumaGrupoActual == sumaNecesariaGrupo) {
            break;
          }
        }
        indiceActual--;
      }
      
      // No encontró posibilidad
      if (indiceActual == -1) {
        return null;
      }
      
      // Se obtienen los valores del grupo 1
      int[] grupoActual = new int[pilaIndicesGrupo.size()];
      for (int indiceGrupo = 0; indiceGrupo < grupoActual.length; indiceGrupo++) {
        grupoActual[indiceGrupo] = numeros[pilaIndicesGrupo.get(indiceGrupo)];
      }
      grupos[gruposEncontrados] = grupoActual;
      gruposEncontrados++;
      
      indicesDisponiblesList.removeAll(pilaIndicesGrupo);
    }

    return grupos;
  }

  private static int calcularSumaArreglo(int[] numeros) {
    int suma = 0;
    for (int numero : numeros) {
      suma += numero;
    }
    return suma;
  }
}

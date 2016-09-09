package challenge2016;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class CombinacionGruposTest {
  @Test
  public void nivel1_sumaDeNumerosNoDanParaDividirPorCantidadDeGrupos() {
    Assert.assertNull(CombinacionGrupos.nivel1_dividirGrupo(new int[] { 1, 2 }));
    Assert.assertNull(CombinacionGrupos.nivel1_dividirGrupo(new int[] { 1, 2, 3, 3 }));
  }

  @Test
  public void nivel1_sumaDeNumerosIndividualesNoDanLaPorcionNecesariaDelGrupo() {
    Assert.assertNull(CombinacionGrupos.nivel1_dividirGrupo(new int[] { 6, 2 }));
    Assert.assertNull(CombinacionGrupos.nivel1_dividirGrupo(new int[] { 3, 3, 2 }));
  }

  @Test
  public void nivel1_divisionDeNumeros() {
    validarGrupos(CombinacionGrupos.nivel1_dividirGrupo(new int[] { 1, 3, 4, 2 }), new int[] { 4, 1 }, new int[] { 2, 3 });
    validarGrupos(CombinacionGrupos.nivel1_dividirGrupo(new int[] { 1, 1, 1, 4, 3, 6 }), new int[] { 6, 1, 1 }, new int[] { 1, 3, 4 });
    validarGrupos(CombinacionGrupos.nivel1_dividirGrupo(new int[] { 1, 1, 1, 1 }), new int[] { 1, 1 }, new int[] { 1, 1 });
  }

  @Test
  public void nivel2_sumaDeNumerosNoDanParaDividirPorCantidadDeGrupos() {
    Assert.assertNull(CombinacionGrupos.nivel2_dividirGrupo(new int[] { 1, 2 }));
    Assert.assertNull(CombinacionGrupos.nivel2_dividirGrupo(new int[] { 1, 2, 3, 3 }));
  }

  @Test
  public void nivel2_sumaDeNumerosIndividualesNoDanLaPorcionNecesariaDelGrupo() {
    Assert.assertNull(CombinacionGrupos.nivel2_dividirGrupo(new int[] { 6, 2 }));
    Assert.assertNull(CombinacionGrupos.nivel2_dividirGrupo(new int[] { 3, 3, 2 }));
  }

  @Test
  public void nivel2_divisionDeNumeros() {
    validarGrupos(CombinacionGrupos.nivel2_dividirGrupo(new int[] { 1, 3, 4, 2, 1, 1 }), new int[] { 4, 2 }, new int[] { 1, 1, 1, 3 });
  }

  @Test
  public void nivel3_sumaDeNumerosNoDanParaDividirPorCantidadDeGrupos() {
    Assert.assertNull(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 2 }, 2));
    Assert.assertNull(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 2, 3, 3 }, 2));
    Assert.assertNull(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 2 }, 3));
    Assert.assertNull(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 2, 3, 4 }, 3));
  }

  @Test
  public void nivel3_sumaDeNumerosIndividualesNoDanLaPorcionNecesariaDelGrupo() {
    Assert.assertNull(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 6, 2 }, 2));
    Assert.assertNull(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 3, 3, 2 }, 2));
    Assert.assertNull(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 6, 2 }, 3));
    Assert.assertNull(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 3, 3, 2 }, 3));
  }

  @Test
  public void nivel3_divisionDeNumeros() {
    validarGrupos(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 3, 4, 2 }, 2), new int[] { 4, 1 }, new int[] { 3, 2 });
    validarGrupos(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 1, 1, 4, 3, 6 }, 2), new int[] { 6, 1, 1 }, new int[] { 4, 3, 1 });
    validarGrupos(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 1, 1, 1 }, 2), new int[] { 1, 1 }, new int[] { 1, 1 });

    validarGrupos(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 3, 4, 2, 2 }, 3), new int[] { 4 }, new int[] { 3, 1 }, new int[] { 2, 2 });
    validarGrupos(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 2, 1, 1, 4, 3, 6 }, 3), new int[] { 6 }, new int[] { 4, 2 }, new int[] { 3, 1, 1, 1 });
    validarGrupos(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 1, 1, 1, 1, 1 }, 3), new int[] { 1, 1 }, new int[] { 1, 1 }, new int[] { 1, 1 });

    validarGrupos(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 3, 4, 2, 4, 2 }, 4), new int[] { 4 }, new int[] { 4 }, new int[] { 3, 1 },
        new int[] { 2, 2 });
    validarGrupos(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 2, 1, 1, 4, 3, 3, 3, 6 }, 4), new int[] { 6 }, new int[] { 4, 2 }, new int[] { 3, 3 },
        new int[] { 3, 1, 1, 1 });
    validarGrupos(CombinacionGrupos.nivel3_dividirGrupo(new int[] { 1, 1, 1, 2, 1, 1, 1 }, 4), new int[] { 2 }, new int[] { 1, 1 }, new int[] { 1, 1 },
        new int[] { 1, 1 });
  }

  private static void validarGrupos(int[][] gruposResultantes, int[]... gruposEsperados) {
    Assert.assertNotNull(gruposResultantes);
    Assert.assertEquals(gruposEsperados.length, gruposResultantes.length);
    for (int i = 0; i < gruposResultantes.length; i++) {
      Assert.assertEquals(Arrays.toString(gruposEsperados[i]), Arrays.toString(gruposResultantes[i]));
      Assert.assertArrayEquals(gruposEsperados[i], gruposResultantes[i]);
    }
  }
}

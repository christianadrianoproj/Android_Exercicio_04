package com.example.appexec04.model;

class Turma (val nome: String) {

    val disciplinas: MutableList<Disciplina> = mutableListOf<Disciplina>()

    fun adicionaDisciplina(d: Disciplina) {
        disciplinas.add(d);
    }

    fun getQuantidadeProvas(): Int {
        var cont: Int = 0;
        disciplinas.forEach {
            it.alunos.forEach { a ->
                if (cont < a.notas.size) {
                    cont = a.notas.size;
                }
            }
        }
        return cont;
    }

    fun getNomeAlunosAprovados(): MutableList<String> {
        val nomes = mutableListOf<String>()
        disciplinas.forEach {
            it.alunos.forEach { a ->
                    if (a.getMediaNotas()?.toDouble()!! >= 7.0) {
                    nomes.add(a.nome);
                }
            }
        }
        return nomes;
    }

    fun getNomeAlunosReprovados(): MutableList<String> {
        val nomes = mutableListOf<String>()
        disciplinas.forEach {
            it.alunos.forEach { a ->
                if (a.getMediaNotas()?.toDouble()!! < 7.0) {
                    nomes.add(a.nome);
                }
            }
        }
        return nomes;
    }

    fun getNomeMelhorAlunoTurma(): MutableList<String> {
        val nomes = mutableListOf<String>();

        nomes.add("Nome do melhor aluno da turma:");

        var media: Double = -1.0;
        var aluno = Aluno("", arrayOf(0.0));

        disciplinas.forEach {
            it.alunos.forEach { a ->
                if (media < a.getMediaNotas()?.toDouble()!!) {
                    media = a.getMediaNotas()?.toDouble()!!;
                    aluno = a;
                }
            }
        }
        val retorno: String = aluno.nome + " - Média: " + String.format("%.2f", aluno.getMediaNotas());
        nomes.add(retorno);

        return nomes;
    }

    fun getMediaTumaPorProva(): MutableList<String> {
        val nomes = mutableListOf<String>();
        val qtdProvas: Int = getQuantidadeProvas() - 1;

        nomes.add("Média da turma $nome em cada uma das provas:");

        for (i in 0..qtdProvas) {
            var notasProva: MutableList<Double> = mutableListOf<Double>();

            disciplinas.forEach {
                it.alunos.forEach { a ->
                    notasProva.add(a.notas[i].toDouble());
                }
            }
            val media = String.format("%.2f", notasProva.average());
            val numProva = i + 1;
            nomes.add("Prova $numProva: $media");
        }

        return nomes;
    }

    fun getNomeMelhorAlunoPorProva(): MutableList<String> {
        val nomes = mutableListOf<String>();
        val qtdProvas: Int = getQuantidadeProvas() - 1;

        nomes.add("Nome do melhor aluno em cada prova:");

        for (i in 0..qtdProvas) {
            var nota: Double = -1.0;
            var aluno = Aluno("", arrayOf(0.0));

            disciplinas.forEach {
                it.alunos.forEach { a ->
                    if (nota < a.notas[i].toDouble()) {
                        nota = a.notas[i].toDouble();
                        aluno = a;
                    }
                }
            }
            val numProva = i + 1;
            val retorno: String = "Prova " + numProva.toString() + ": " +  aluno.nome+ " - " + String.format("%.2f", nota);
            nomes.add(retorno);
        }

        return nomes;
    }

}
package com.example.appexec04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.appexec04.model.Aluno
import com.example.appexec04.model.Disciplina
import com.example.appexec04.model.Turma

class MainActivity : AppCompatActivity() {

    private lateinit var opcaoRelatorioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        opcaoRelatorioGroup = findViewById<RadioGroup>(R.id.rg_opcao_relatorio)

        val btn = findViewById<Button>(R.id.bt_relatorio)
        btn.setOnClickListener {
            if (validate()) {

                val disciplina = Disciplina("DDM");
                disciplina.adicionaAluno(Aluno("Christian Adriano", arrayOf(9.0,8.5,7.7)));
                disciplina.adicionaAluno(Aluno("Ana Paula Martins", arrayOf(6.0,8.0,7.5)));
                disciplina.adicionaAluno(Aluno("Antonio da Costa", arrayOf(9.4,7.9,9.0)));
                disciplina.adicionaAluno(Aluno("João da Silva", arrayOf(7.1,5.9,5.5)));
                disciplina.adicionaAluno(Aluno("Carlos Martins", arrayOf(2.9,7.8,7.2)));
                disciplina.adicionaAluno(Aluno("Luiz Vinicius", arrayOf(5.7,7.6,8.6)));
                disciplina.adicionaAluno(Aluno("Fernanda", arrayOf(8.6,7.8,9.5)));
                disciplina.adicionaAluno(Aluno("Iara", arrayOf(9.5,5.6,7.1)));
                disciplina.adicionaAluno(Aluno("Paula da Costa", arrayOf(8.4,3.5,5.5)));
                disciplina.adicionaAluno(Aluno("Marcos Antonio", arrayOf(9.4,7.0,8.4)));
                disciplina.adicionaAluno(Aluno("Adriano Machado", arrayOf(5.0,7.0,6.5)));

                val turma = Turma("ADS");
                turma.adicionaDisciplina(disciplina);

                var relatorio = ""

                if (opcaoRelatorioGroup.checkedRadioButtonId == R.id.rb_nomeAlunosAprovado) {
                    turma.getNomeAlunosAprovados().forEach {
                        relatorio += it.toString() + "\n";
                    }
                }

                if (opcaoRelatorioGroup.checkedRadioButtonId == R.id.rb_MediaTurmaProvas) {
                    turma.getMediaTumaPorProva().forEach {
                        relatorio += it.toString() + "\n";
                    }
                }

                if (opcaoRelatorioGroup.checkedRadioButtonId == R.id.rb_NumeroAlunosAprovadosReprovados) {
                    relatorio = "Números de Alunos: \n";
                    relatorio += "   Aprovados: " + turma.getNomeAlunosAprovados().size.toString();
                    relatorio += "   Reprovados: " + turma.getNomeAlunosReprovados().size.toString();
                }

                if (opcaoRelatorioGroup.checkedRadioButtonId == R.id.rb_NomeMelhorAlunoTurma) {
                    turma.getNomeMelhorAlunoTurma().forEach {
                        relatorio += it.toString() + "\n";
                    }
                }

                if (opcaoRelatorioGroup.checkedRadioButtonId == R.id.rb_NomeMelhorAlunoCadaProva) {
                    turma.getNomeMelhorAlunoPorProva().forEach {
                        relatorio += it.toString() + "\n";
                    }
                }

                AlertDialog.Builder(this)
                    .setTitle("Avaliações dos Alunos")
                    .setMessage(relatorio)
                    .setPositiveButton("OK") { dialog, which -> dialog.dismiss()
                    }.show()
            }
        }
    }

    private fun validate() : Boolean {
        var result = true
        return result
    }
}


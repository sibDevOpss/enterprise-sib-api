package com.enterprise.sib.api.log;

import com.enterprise.sib.api.cpf.CpfMassaReqMdl;
import com.enterprise.sib.api.cpf.CpfReqMdl;
import com.enterprise.sib.utilitarios.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogCtrl {


	@Autowired
	private LogDAO logfDAO;



	// Metodo para gravar o log do endpoint "consultar_cpf" , serve para gravar 1 cpf no log
	public void gravaLog(CpfReqMdl params) {

		Utils utilitarios = new Utils();

		String mascaraDataHora = "dd-MM-yyyy HH:mm:ss";

		String pathSaidaDadosLog = "C:\\Users\\Godzilla\\Desktop\\saidas\\";

		String extensaoArqLog = ".txt";

		LocalDateTime dataHoraConsulta = utilitarios.obtemDataHoraAtual();

		DateTimeFormatter formataDataHora = utilitarios.obtemTipoDataHoraFormatado(mascaraDataHora);

		DadosLogCpfMdl dadosLog = utilitarios.defineDataHoraLocal(dataHoraConsulta, formataDataHora);

		dadosLog = utilitarios.defineDadosLogCpf(dadosLog, params);

		String infoLog = utilitarios.criaDadosLog(dadosLog);

		String nomeArqLog = utilitarios.obtemNomeArqSaidaLog(dadosLog, extensaoArqLog);

		//utilitarios.gravarArquivoLog(pathSaidaDadosLog, nomeArqLog, infoLog);

		salvarLogNoBanco (dadosLog);


	}

	// Metodo para gravar o log do endpoint "consultar_cpf_massa" , serve para gravar VÁRIOS cpfs no log
	public void gravaLogCpfEmMassa(CpfMassaReqMdl params) {

		Utils utilitarios = new Utils();

		String mascaraDataHora = "dd-MM-yyyy HH:mm:ss";

		String pathSaidaDadosLog = "C:\\Users\\Godzilla\\Desktop\\saidas\\";

		String extensaoArqLog = ".txt";

		String cpfsConcatenados = utilitarios.concatenaListaCpfEmString(params.getListaCpfs());

		LocalDateTime dataHoraConsulta = utilitarios.obtemDataHoraAtual();

		DateTimeFormatter formataDataHora = utilitarios.obtemTipoDataHoraFormatado(mascaraDataHora);

		DadosLogCpfMdl dadosLog = utilitarios.defineDataHoraLocal(dataHoraConsulta, formataDataHora);

		dadosLog = utilitarios.defineDadosLogCpfMassa(dadosLog, params,cpfsConcatenados);

		String infoLog = utilitarios.criaDadosLog(dadosLog);

		String nomeArqLog = utilitarios.obtemNomeArqSaidaLog(dadosLog, extensaoArqLog);

		//utilitarios.gravarArquivoLog(pathSaidaDadosLog, nomeArqLog, infoLog);

		salvarLogNoBanco (dadosLog);

	}

	public void salvarLogNoBanco (DadosLogCpfMdl dadosLog) {

		DadosLogCpfJPAMdl log = carregaObjetoLogParaSalvar(dadosLog);
		logfDAO.save(log);

	}

	public DadosLogCpfJPAMdl carregaObjetoLogParaSalvar (DadosLogCpfMdl dadosLog) {

		DadosLogCpfJPAMdl dadosJPA = new DadosLogCpfJPAMdl();

		dadosJPA.setCodigoOperadora(dadosLog.getParamsConsulta().getCodigoOperadora());
		dadosJPA.setNomeOperadora(dadosLog.getParamsConsulta().getNomeOperadora());
		dadosJPA.setNomeUsuario(dadosLog.getParamsConsulta().getNomeUsuario());
		dadosJPA.setCpf(dadosLog.getParamsConsulta().getCpf());
		dadosJPA.setData(dadosLog.getDataHora().getData());
		dadosJPA.setHora(dadosLog.getDataHora().getHora());

		return dadosJPA;
	}

	public List<DadosLogCpfJPAMdl> obtemTodosLogBase () {

		List<DadosLogCpfJPAMdl> listaLogsBase = new ArrayList<>();

		for (DadosLogCpfJPAMdl log : logfDAO.findAll()) {
			listaLogsBase.add(log);
		}

		return listaLogsBase;
	}

	public List<DadosLogCpfJPAMdl> obtemLogsDeUmaOperadora (String nomeOperadora) {

		List<DadosLogCpfJPAMdl> listaLogsEncontrados = new ArrayList<>();

		for (DadosLogCpfJPAMdl log : logfDAO.findLogsByNomeOperadora(nomeOperadora)) {
			listaLogsEncontrados.add(log);
		}

		return listaLogsEncontrados;
	}

	public List<DadosLogCpfJPAMdl> obtemLogsPorNomeUsuario (String nomeUsuario) {

		List<DadosLogCpfJPAMdl> listaLogsEncontrados = new ArrayList<>();

		for (DadosLogCpfJPAMdl log : logfDAO.findLogsByNomeUsuario(nomeUsuario)) {
			listaLogsEncontrados.add(log);
		}

		return listaLogsEncontrados;
	}
	
	public List<DadosLogCpfJPAMdl> obtemLogsPorCodigoOperadora (int codigoOperadora) {

		List<DadosLogCpfJPAMdl> listaLogsEncontrados = new ArrayList<>();

		for (DadosLogCpfJPAMdl log : logfDAO.findLogsByCodigoOperadora(codigoOperadora)) {
			listaLogsEncontrados.add(log);
		}

		return listaLogsEncontrados;
	}
	
	public int obtemQuantidadeRegistrosLogNoBanco () {
		
		List<DadosLogCpfJPAMdl> listaLogsBase = obtemTodosLogBase();
		return listaLogsBase.size();
	}


}

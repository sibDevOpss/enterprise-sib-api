package com.enterprise.sib.api.log;

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
	private LogDAO logDAO;



	// Metodo para gravar o log do endpoint "consultar_cpf" , serve para gravar 1 cpf no log
	public void gravaLog(CpfReqMdl params, String retorno, boolean indicadorSucessoBusca) {

		Utils utilitarios = new Utils();

		String mascaraDataHora = "dd-MM-yyyy HH:mm:ss";

		LocalDateTime dataHoraConsulta = utilitarios.obtemDataHoraAtual();

		DateTimeFormatter formataDataHora = utilitarios.obtemTipoDataHoraFormatado(mascaraDataHora);

		DadosLogCpfMdl dadosLog = utilitarios.defineDataHoraLocal(dataHoraConsulta, formataDataHora);
		
		dadosLog = utilitarios.defineDadosLogCpf(dadosLog, params);
		
		DadosLogJPAMdl dados = carregaObjetoLogParaSalvar(dadosLog, retorno, indicadorSucessoBusca);

		logDAO.save(dados);


	}

	// Metodo para gravar o log do endpoint "consultar_cpf_massa" , serve para gravar VÁRIOS cpfs no log
	//	public void gravaLogCpfEmMassa(CpfMassaReqMdl params) {
	//
	//		Utils utilitarios = new Utils();
	//
	//		String mascaraDataHora = "dd-MM-yyyy HH:mm:ss";
	//
	//		String pathSaidaDadosLog = "C:\\Users\\Godzilla\\Desktop\\saidas\\";
	//
	//		String extensaoArqLog = ".txt";
	//
	//		String cpfsConcatenados = utilitarios.concatenaListaCpfEmString(params.getListaCpfs());
	//
	//		LocalDateTime dataHoraConsulta = utilitarios.obtemDataHoraAtual();
	//
	//		DateTimeFormatter formataDataHora = utilitarios.obtemTipoDataHoraFormatado(mascaraDataHora);
	//
	//		DadosLogCpfMdl dadosLog = utilitarios.defineDataHoraLocal(dataHoraConsulta, formataDataHora);
	//
	//		dadosLog = utilitarios.defineDadosLogCpfMassa(dadosLog, params,cpfsConcatenados);
	//
	//		String infoLog = utilitarios.criaDadosLog(dadosLog);
	//
	//		String nomeArqLog = utilitarios.obtemNomeArqSaidaLog(dadosLog, extensaoArqLog);
	//
	//		//utilitarios.gravarArquivoLog(pathSaidaDadosLog, nomeArqLog, infoLog);
	//
	//		salvarLogNoBanco (dadosLog);
	//
	//	}

	public DadosLogJPAMdl carregaObjetoLogParaSalvar (DadosLogCpfMdl dadosLog, String retorno, boolean indicadorSucessoBusca) {

		DadosLogJPAMdl dadosJPA = new DadosLogJPAMdl();

		dadosJPA.setUsuarioId(dadosLog.getParamsConsulta().getUsuarioId());
		dadosJPA.setUsuarioNome(dadosLog.getParamsConsulta().getUsuarioNome());
		dadosJPA.setOperadoraId(dadosLog.getParamsConsulta().getOperadoraId());
		dadosJPA.setOperadoraNome(dadosLog.getParamsConsulta().getOperadoraNome());
		dadosJPA.setOperadoraCnpj(dadosLog.getParamsConsulta().getOperadoraCnpj());
		dadosJPA.setBody(dadosLog.getJsonEntradaEndpoint());
		dadosJPA.setRetorno(retorno);
		dadosJPA.setSucesso(indicadorSucessoBusca); 
		dadosJPA.setCpf(dadosLog.getParamsConsulta().getCpf());
		dadosJPA.setDataNascimento(dadosLog.getParamsConsulta().getDataNascimento());
		dadosJPA.setData(dadosLog.getDataHora().getData());
		dadosJPA.setHora(dadosLog.getDataHora().getHora());
		//dadosJPA.setIp("IP");
		//dadosJPA.setHost("HOST");

		return dadosJPA;
	}

	public List<DadosLogJPAMdl> obtemTodosLogBase () {

		List<DadosLogJPAMdl> listaLogsBase = new ArrayList<>();

		for (DadosLogJPAMdl log : logDAO.findAll()) {
			listaLogsBase.add(log);
		}

		return listaLogsBase;
	}

	public List<DadosLogJPAMdl> obtemLogsDeUmaOperadora (String nomeOperadora) {

		List<DadosLogJPAMdl> listaLogsEncontrados = new ArrayList<>();

		for (DadosLogJPAMdl log : logDAO.findLogsByNomeOperadora(nomeOperadora)) {
			listaLogsEncontrados.add(log);
		}

		return listaLogsEncontrados;
	}

	public List<DadosLogJPAMdl> obtemLogsPorNomeUsuario (String nomeUsuario) {

		List<DadosLogJPAMdl> listaLogsEncontrados = new ArrayList<>();

		for (DadosLogJPAMdl log : logDAO.findLogsByNomeUsuario(nomeUsuario)) {
			listaLogsEncontrados.add(log);
		}

		return listaLogsEncontrados;
	}

	public List<DadosLogJPAMdl> obtemLogsPorCodigoOperadora (int codigoOperadora) {

		List<DadosLogJPAMdl> listaLogsEncontrados = new ArrayList<>();

		for (DadosLogJPAMdl log : logDAO.findLogsByCodigoOperadora(codigoOperadora)) {
			listaLogsEncontrados.add(log);
		}

		return listaLogsEncontrados;
	}
	
	
	public List<DadosLogJPAMdl> obtemLogsPorOperadoraCnpj (String operadoraCNPJ) {

		List<DadosLogJPAMdl> listaLogsEncontrados = new ArrayList<>();

		for (DadosLogJPAMdl log : logDAO.findLogsByOperadoraCnpj(operadoraCNPJ)) {
			listaLogsEncontrados.add(log);
		}

		return listaLogsEncontrados;
	}
	
	
	public List<DadosLogJPAMdl> obtemLogsUsuarioId (String usuarioId) {

		List<DadosLogJPAMdl> listaLogsEncontrados = new ArrayList<>();

		for (DadosLogJPAMdl log : logDAO.findLogsByUsuarioId(usuarioId)) {
			listaLogsEncontrados.add(log);
		}

		return listaLogsEncontrados;
	}

	public int obtemQuantidadeRegistrosLogNoBanco () {

		List<DadosLogJPAMdl> listaLogsBase = obtemTodosLogBase();
		return listaLogsBase.size();
	}


}

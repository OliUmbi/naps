package ch.bbbaden.naps.security.mappers;

import ch.bbbaden.naps.security.daos.SecurityTokenDAO;
import ch.bbbaden.naps.security.dtos.token.response.SecurityResponseAccessTokenDTO;
import ch.bbbaden.naps.security.dtos.token.response.SecurityResponseRefreshTokenDTO;
import org.springframework.stereotype.Component;

@Component
public class SecurityTokenMapper {
	public SecurityResponseAccessTokenDTO mapSecurityTokenDAOToSecurityResponseAccessTokenDTO (SecurityTokenDAO tokenDAO) {
		SecurityResponseAccessTokenDTO responseAccessTokenDTO = new SecurityResponseAccessTokenDTO();
		
		responseAccessTokenDTO.setAccess(tokenDAO.getAccess());
		responseAccessTokenDTO.setRefresh(tokenDAO.getRefresh());
		responseAccessTokenDTO.setExpires(tokenDAO.getExpires());
		
		return responseAccessTokenDTO;
	}
	
	public SecurityResponseRefreshTokenDTO mapSecurityTokenDAOToSecurityResponseRefreshTokenDTO (SecurityTokenDAO tokenDAO) {
		SecurityResponseRefreshTokenDTO responseRefreshTokenDTO = new SecurityResponseRefreshTokenDTO();
		
		responseRefreshTokenDTO.setAccess(tokenDAO.getAccess());
		responseRefreshTokenDTO.setExpires(tokenDAO.getExpires());
		
		return responseRefreshTokenDTO;
	}
}

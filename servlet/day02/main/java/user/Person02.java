package user;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
public class Person02 {
		private String name;
		private  Address address;
		private String[] movie;
		private  List<String> like;
		private Map<String,Object> card;
		private Set<String> games;
		private String lovePerson;
		private Properties init;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public String[] getMovie() {
			return movie;
		}
		public void setMovie(String[] movie) {
			this.movie = movie;
		}
		public List<String> getLike() {
			return like;
		}
		public void setLike(List<String> like) {
			this.like = like;
		}
		public Map<String, Object> getCard() {
			return card;
		}
		public void setCard(Map<String, Object> card) {
			this.card = card;
		}
		public Set<String> getGames() {
			return games;
		}
		public void setGames(Set<String> games) {
			this.games = games;
		}
		public String getLovePerson() {
			return lovePerson;
		}
		public void setLovePerson(String lovePerson) {
			this.lovePerson = lovePerson;
		}
		public Properties getInit() {
			return init;
		}
		public void setInit(Properties init) {
			this.init = init;
		}
		@Override
		public String toString() {
			return "Person02 [name=" + name + ", address=" + address + ", movie=" + Arrays.toString(movie) + ", like="
					+ like + ", card=" + card + ", games=" + games + ", lovePerson=" + lovePerson + ", init=" + init
					+ "]";
		}
		
       
}

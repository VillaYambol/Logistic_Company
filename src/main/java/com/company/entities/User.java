package com.company.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

	private String username;
	private String password;
	private String name;
	private EmployeeType employeeType;
	private List<Shipment> shipments;
	private Office office;
	private List<Shipment> sentShipments;
	private List<Shipment> receivedShipments;
	private Set<Role> authorities;

	public User() {
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	@JoinColumn
	@ManyToOne
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "employee_type", nullable = true, unique = false, updatable = true)
	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
	public List<Shipment> getSentShipments() {
		return sentShipments;
	}

	public void setSentShipments(List<Shipment> sentShipments) {
		this.sentShipments = sentShipments;
	}

	@OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
	public List<Shipment> getReceivedShipments() {
		return receivedShipments;
	}

	public void setReceivedShipments(List<Shipment> receivedShipments) {
		this.receivedShipments = receivedShipments;
	}

	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	@Column(name = "name", nullable = false, unique = false, updatable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	public Set<Role> getAuthorities() {
		return authorities;
	}

	@Override
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	@Override
	@Column(name = "username", nullable = false, unique = true, updatable = false)
	public String getUsername() {
		return username;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		return true;
	}

}

package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.impl.FragmentImpl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the Abstract Syntax Tree node for a record type.
 * This one is a scope to allow an easy access to the fields.
 * @author Marc Pantel
 *
 */
public class RecordTypeImpl implements RecordType, Scope<FieldDeclaration> {

	private List<FieldDeclaration> fields;
	private String name;

	/**
	 * Constructor for a record type including fields.
	 * @param _name Name of the record type.
	 * @param _fields Sequence of fields to initialize the content of the record type.
	 */
	public RecordTypeImpl(String _name, Iterable<FieldDeclaration> _fields) {
		this.name = _name;
		this.fields = new LinkedList<>();
		for (FieldDeclaration _field : _fields) {
			this.fields.add(_field);
		}
	}

	/**
	 * Constructor for an empty record type (i.e. without fields).
	 * @param _name Name of the record type.
	 */
	public RecordTypeImpl(String _name) {
		this.name = _name;
		this.fields = new LinkedList<>();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.RecordType#add(fr.n7.stl.block.ast.FieldDeclaration)
	 */
	@Override
	public void add(FieldDeclaration _field) {
		this.fields.add(_field);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.RecordType#addAll(java.lang.Iterable)
	 */
	@Override
	public void addAll(Iterable<FieldDeclaration> _fields) {
		for (FieldDeclaration _field : _fields) {
			this.fields.add(_field);
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof RecordTypeImpl) {
		    return this.erase().equalsTo(((RecordTypeImpl) _other).erase());
        } else {
		    return _other instanceof SequenceTypeImpl && this.erase().compatibleWith(_other);
        }
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
        if (_other instanceof RecordTypeImpl) {
            return this.erase().compatibleWith(((RecordTypeImpl) _other).erase());
        } else {
            return _other instanceof SequenceTypeImpl && this.erase().compatibleWith(_other);
        }
    }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
	    throw new SemanticsUndefinedException("merge undefined for RecordTypeImpl");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Scope#get(java.lang.String)
	 */
	@Override
	public Optional<FieldDeclaration> get(String _name) {
		boolean _found = false;
		Iterator<FieldDeclaration> _iter = this.fields.iterator();
		FieldDeclaration _current = null;
		while (_iter.hasNext() && (! _found)) {
			_current = _iter.next();
			_found = _current.getName().contentEquals(_name);
		}
		if (_found) {
			return Optional.of(_current);
		} else {
			return Optional.empty();
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Scope#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String _name) {
		boolean _result = false;
		Iterator<FieldDeclaration> _iter = this.fields.iterator();
		while (_iter.hasNext() && (! _result)) {
			_result = _iter.next().getName().contentEquals(_name);
		}
		return _result;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Scope#accepts(fr.n7.stl.block.ast.Declaration)
	 */
	@Override
	public boolean accepts(FieldDeclaration _declaration) {
		return ! this.contains(_declaration.getName());
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Scope#register(fr.n7.stl.block.ast.Declaration)
	 */
	@Override
	public void register(FieldDeclaration _declaration) throws ForbiddenDeclarationException {
		if (this.accepts(_declaration)) {
			this.fields.add(_declaration);
		}
		
	}
	
	/**
	 * Build a sequence type by erasing the names of the fields.
	 * @return Sequence type extracted from record fields.
	 */
	public SequenceTypeImpl erase() {
		SequenceTypeImpl _local = new SequenceTypeImpl();
		for (FieldDeclaration _field : this.fields) {
			_local.add(_field.getType());
		}
		return _local;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length()
	 */
	@Override
	public int length() {
		int _length = 0;
		for (FieldDeclaration f : this.fields) {
			_length += f.getType().length();
		}
		return _length;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _result = "struct " + this.name + " { ";
		Iterator<FieldDeclaration> _iter = this.fields.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
			while (_iter.hasNext()) {
				_result += " " + _iter.next();
			}
		}
		return _result + "}";
	}

	@Override
	public boolean checkType() {
		return true;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
        return new FragmentImpl();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Type getType() {
		return this;
	}

}

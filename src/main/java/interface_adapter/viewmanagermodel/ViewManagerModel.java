package interface_adapter.viewmanagermodel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewManagerModel {
    private String state;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void setState(String newState) {
        String oldState = this.state;
        this.state = newState;
        firePropertyChanged("state", oldState, newState);
    }

    private void firePropertyChanged(String propertyName, String oldValue, String newValue) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    }
}
